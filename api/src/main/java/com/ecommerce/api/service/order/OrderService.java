package com.ecommerce.api.service.order;

import com.ecommerce.api.dto.order.OrderRequest;
import com.ecommerce.api.dto.order.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    List<OrderResponse> getOrders();

    OrderResponse getOrder(Long id);
}
