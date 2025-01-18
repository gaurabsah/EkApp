package com.ekApp.service;

import com.ekApp.dto.ProductRequest;
import com.ekApp.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
