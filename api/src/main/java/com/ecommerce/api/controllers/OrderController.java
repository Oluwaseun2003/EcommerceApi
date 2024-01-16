package com.ecommerce.api.controllers;


import com.ecommerce.api.dto.order.OrderRequest;
import com.ecommerce.api.dto.order.OrderResponse;
import com.ecommerce.api.service.order.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<OrderResponse> creatOrder(@Valid @RequestBody OrderRequest orderRequest){
        OrderResponse createdOrder = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }
    @GetMapping("")
    public ResponseEntity<List<OrderResponse>> getOrders() {
        List<OrderResponse> products = orderService.getOrders();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        OrderResponse orderResponse = orderService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }
}
