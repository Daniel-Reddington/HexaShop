package com.learning.hexashop.product.adapter.in.web.controller;

import com.learning.hexashop.product.adapter.in.web.dto.CreateProductRequest;
import com.learning.hexashop.product.adapter.in.web.dto.ProductResponse;
import com.learning.hexashop.product.domain.model.ProductId;
import com.learning.hexashop.product.domain.port.in.CreateProductUseCase;
import com.learning.hexashop.product.domain.port.in.GetProductByIdUseCase;
import com.learning.hexashop.product.domain.port.in.GetProductsUseCase;
import com.learning.hexashop.shared.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;
    private final GetProductsUseCase getProductsUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ProductResponse> create(@RequestBody CreateProductRequest request) {
        var command = request.toCommand();

        var response = createProductUseCase.create(command);

        return ApiResponse.success(ProductResponse.from(response));
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getById(@PathVariable String id) {
        var response = getProductByIdUseCase.getById(ProductId.fromString(id)).orElseThrow(() -> new RuntimeException("Product not found"));

        return ApiResponse.success(ProductResponse.from(response));
    }

    @GetMapping
    public ApiResponse<Page<ProductResponse>> getAll(Pageable pageable) {
        var response = getProductsUseCase.getProducts(pageable).map(ProductResponse::from);

        return ApiResponse.success(response);
    }
}


