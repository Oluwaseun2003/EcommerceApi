package com.ecommerce.api.service.product;

import com.ecommerce.api.dto.product.ProductRequest;
import com.ecommerce.api.dto.product.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts();

    ProductResponse getProduct(Long id);
}
