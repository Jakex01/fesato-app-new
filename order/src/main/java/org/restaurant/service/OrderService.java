package org.restaurant.service;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import org.restaurant.request.OrderRequest;
import org.restaurant.response.OrderResponse;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface OrderService {
    ResponseEntity<?> postOrder(OrderRequest orderRequest, String token) throws DocumentException, IOException, URISyntaxException;

    ResponseEntity<List<OrderResponse>> getOrdersByUser(String token);

    ResponseEntity<byte[]> getPdfOrder(Long id);
}
