package com.ecommerce.api.service.order;

import com.ecommerce.api.dto.order.OrderRequest;
import com.ecommerce.api.dto.order.OrderResponse;
import com.ecommerce.api.entities.Order;
import com.ecommerce.api.entities.OrderItem;
import com.ecommerce.api.entities.Product;
import com.ecommerce.api.entities.User;
import com.ecommerce.api.exceptions.RecordNotFoundException;
import com.ecommerce.api.repositories.OrderRepo;
import com.ecommerce.api.repositories.ProductRepo;
import com.ecommerce.api.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderImpl implements OrderService{
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        String errorMessage = String.format("User with id %d not found", orderRequest.getUserid());
        User user = userRepo.findById(orderRequest.getUserid())
                .orElseThrow(() -> new RecordNotFoundException(errorMessage));

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());

        Order savedOrder = orderRepo.save(order);

        List<OrderItem> orderItems = createOrderItems(orderRequest.getProductItems(), savedOrder);
        savedOrder.setOrderItems(orderItems);

        double totalAmount = calculateTotalAmount(orderItems);
        savedOrder.setTotalAmount(totalAmount);

        savedOrder =orderRepo.save(savedOrder);
        return mapOrderToResponse(savedOrder);


    }

    @Override
    public List<OrderResponse> getOrders() {
        return null;
    }

    @Override
    public OrderResponse getOrder(Long id) {
        return null;
    }



    private double calculateTotalAmount(List<OrderItem> orderItems) {
        return orderItems.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    private List<OrderItem> createOrderItems(List<OrderRequest.ProductItem> orderRequests, Order order) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderRequest.ProductItem orderProductItem : orderRequests) {
            Long productId = orderProductItem.getProductId();
            int quantity = orderProductItem.getQuantity();

            String errorMessage = String.format("Product not found with id %d", productId);

            Product product = productRepo.findById(productId)
                    .orElseThrow(() -> new RecordNotFoundException(errorMessage));

            OrderItem orderItem = OrderItem.builder()
                    .quantity(quantity)
                    .subtotal(product.getPrice() * quantity)
                    .product(product)
                    .order(order)
                    .build();

            orderItems.add(orderItem);
        }

        return orderItems;
    }

    private OrderResponse mapOrderToResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId((long) Math.toIntExact(order.getId()));
        orderResponse.setUserId((long) Math.toIntExact(order.getUser().getId()));
        orderResponse.setOrderDate(order.getOrderDate().toString());
        orderResponse.setTotalAmount(order.getTotalAmount());
        orderResponse.setOrderItemList(mapOrderItemsToResponse(order.getOrderItems()));
        return orderResponse;
    }

    private List<OrderResponse.OrderItem> mapOrderItemsToResponse(List<OrderItem> orderItems){
        return (List<OrderResponse.OrderItem>) orderItems.stream()
                .map(orderItem -> OrderResponse.OrderItem.builder()
                        .productId((long) Math.toIntExact(orderItem.getProduct().getId()))
                        .quantity(orderItem.getQuantity())
                        .subtotal(orderItem.getSubtotal())
                        .build())
                .collect(Collectors.toList());
    }
}





