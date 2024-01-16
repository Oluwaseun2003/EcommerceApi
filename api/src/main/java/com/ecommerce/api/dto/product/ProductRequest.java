package com.ecommerce.api.dto.product;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String Description;
    private double price;
    private int stockQuantity;
}
