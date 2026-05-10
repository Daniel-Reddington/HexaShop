package com.learning.hexashop.product.adapter.in.web;

import com.learning.hexashop.product.adapter.in.web.controller.ProductController;
import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.port.in.CreateProductUseCase;
import com.learning.hexashop.product.domain.port.in.GetProductByIdUseCase;
import com.learning.hexashop.product.domain.port.in.GetProductsUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CreateProductUseCase createProductUseCase;

    @MockitoBean
    private GetProductByIdUseCase getProductByIdUseCase;

    @MockitoBean
    private GetProductsUseCase getProductsUseCase;

    @Test
    void should_create_product() throws Exception {

        Product product = Product.create("Laptop", 100);
        when(createProductUseCase.create(any())).thenReturn(product);

        String json = """
                {
                    "name": "Laptop",
                    "price": 100
                }
                """;

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.name").value("Laptop"))
                .andExpect(jsonPath("$.data.price").value(100))
                .andDo(print());
    }

    @Test
    void should_get_product_by_id() throws Exception {
        Product product = Product.create("Laptop", 100);
        String id = product.getId().toString();

        when(getProductByIdUseCase.getById(any())).thenReturn(Optional.of(product));

        mockMvc.perform(get("/products/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value("Laptop"))
                .andExpect(jsonPath("$.data.price").value(100))
                .andDo(print());
    }

    @Test
    void should_get_all_products_list() throws Exception {
        Product product = Product.create("Laptop", 100);
        Product product2 = Product.create("Phone", 100);

        Page<Product> page = new PageImpl<>(List.of(product,  product2));

        when(getProductsUseCase.getProducts(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/products")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.content[0].name").value("Laptop"))
                .andExpect(jsonPath("$.data.content[0].price").value(100))
                .andDo(print());

    }

}
