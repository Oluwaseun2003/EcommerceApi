package com.ecommerce.api.dto.order;

import com.ecommerce.api.entities.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private Long userId;
    private String orderDate;
    private double totalAmount;
    private List<OrderItem> orderItemList;

    @Data
    @Builder
    public static class OrderItem{
        private Long productId;
        private int quantity;
        private double subtotal;
    }
}
