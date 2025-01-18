package com.ekApp.service.impl;

import com.ekApp.dto.ProductRequest;
import com.ekApp.dto.ProductResponse;
import com.ekApp.model.Product;
import com.ekApp.repository.ProductRepository;
import com.ekApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        String id = UUID.randomUUID().toString();
        Product product = Product.builder()
                .id(id)
                .name(productRequest.name())
                .description(productRequest.description())
                .skuCode(productRequest.skuCode())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                product.getSkuCode(),
                product.getPrice());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                        product.getSkuCode(),
                        product.getPrice()))
                .toList();
    }
}