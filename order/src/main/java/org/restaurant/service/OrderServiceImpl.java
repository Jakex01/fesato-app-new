package org.restaurant.service;

import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;

import lombok.SneakyThrows;
import org.restaurant.config.RabbitMQConfig;
import org.restaurant.mapstruct.MapStructMapper;
import org.restaurant.mapstruct.OrderMapper;
import org.restaurant.model.MessageNotification;
import org.restaurant.model.OrderEntity;
import org.restaurant.repository.OrderRepository;
import org.restaurant.request.OrderRequest;
import org.restaurant.response.OrderResponse;
import org.restaurant.util.JwtUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@CrossOrigin
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final PdfServiceImpl pdfService;
    private final RabbitTemplate rabbitTemplate;
    private final WebClient webClient;

    @SneakyThrows
    public ResponseEntity<?> postOrder(OrderRequest orderRequest, String token)  {


        OrderEntity order = MapStructMapper.INSTANCE.requestToEntity(orderRequest);
        orderRepository.save(order);

        SendPdfToNotification(orderRequest, token);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<OrderResponse>> getOrdersByUser(String token) {

        try {
            String jwtToken = JwtUtil.extractToken(token);

            String userEmail = webClient.get()
                    .uri("http://localhost:8762/api/auth/user")
                    .header("Authorization", "Bearer " + jwtToken)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            List<OrderResponse> orderResponse = orderRepository
                    .findAllByEmail(userEmail)
                    .stream()
                    .map(OrderMapper.INSTANCE::orderEntityToOrderResponse)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(orderResponse);
        } catch (WebClientResponseException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<byte[]> getPdfOrder(Long id) {

        Optional<OrderEntity> order = orderRepository.findById(id);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        return ResponseEntity.ok(byteArrayOutputStream.toByteArray());

    }

    @SneakyThrows
    public void SendPdfToNotification(OrderRequest orderRequest, String token)  {

        String jwtToken = JwtUtil.extractToken(token);

        String userEmail = webClient.get()
                .uri("http://localhost:8762/api/auth/user")
                .header("Authorization", "Bearer " + jwtToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        byte[] pdfContent = pdfService.generatePdf(orderRequest);

        MessageNotification messageNotification = MessageNotification.builder()
                .email(userEmail)
                .pdfContent(Base64.getEncoder().encodeToString(pdfContent))
                .build();

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, messageNotification);
    }





}
