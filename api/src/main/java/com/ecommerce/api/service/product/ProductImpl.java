package com.ecommerce.api.service.product;

import com.ecommerce.api.dto.product.ProductRequest;
import com.ecommerce.api.dto.product.ProductResponse;
import com.ecommerce.api.entities.Product;
import com.ecommerce.api.exceptions.RecordNotFoundException;
import com.ecommerce.api.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductImpl implements ProductService{
    private final ProductRepo productRepo;

    public ProductResponse mapProductToResponse(Product product){
        ProductResponse response = new ProductResponse();

        response.setId((long) Math.toIntExact(product.getId()));
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStockQuantity(product.getStockQuantity());

        return response;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product newProduct = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .stockQuantity(productRequest.getStockQuantity())
                .build();

        Product savedProduct = productRepo.save(newProduct);
        return mapProductToResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products){
            ProductResponse productResponse = mapProductToResponse(product);
            productResponses.add(productResponse);
        }
        return productResponses;
    }

    @Override
    public ProductResponse getProduct(Long id) {
        String errorMessage = String.format("Product with id %d not found", id);
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(errorMessage));

        return mapProductToResponse(product);
    }
}
