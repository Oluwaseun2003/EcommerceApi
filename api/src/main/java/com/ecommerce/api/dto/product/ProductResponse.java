package com.ecommerce.api.dto.product;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
}
