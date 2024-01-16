package com.ecommerce.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    @NonNull
    private Integer statusCode;
    @NonNull private String message;
    private T data;

}
