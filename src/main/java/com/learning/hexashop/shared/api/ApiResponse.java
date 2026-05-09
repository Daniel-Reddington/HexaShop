package com.learning.hexashop.shared.api;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiResponse<T>{

    private final boolean success;
    private final T data;
    private final String message;

    public static <T>ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(false, null, message);
    }
}
