package com.ecommerce.api.dto.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Long userid;
    private List<ProductItem> productItems;

    @Data
    public static class ProductItem{
        private Long productId;
        private int quantity;
    }
}
