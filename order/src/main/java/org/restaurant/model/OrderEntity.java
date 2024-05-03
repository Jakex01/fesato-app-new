package org.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.restaurant.model.enums.OrderStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_request_id")
    private List<MenuItemOrder> items;

    private Double totalPrice;

    private Long restaurantId;
    private String restaurantName;
    private Double tip;
    private Double deliveryFee;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(length = 1024)
    private String orderNote;

    private String email;

    @CreatedDate
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createDate;


    private LocalDateTime deliveryDate;
//
//    @LastModifiedDate
//    @Column
//    private LocalDateTime updateTime;

}
