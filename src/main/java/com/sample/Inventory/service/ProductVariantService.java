package com.sample.Inventory.service;

import com.sample.Inventory.domain.ProductVariant;
import com.sample.Inventory.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductVariantService {
    @Autowired
    ProductVariantRepository productVariantRepository;

    public ProductVariant save(ProductVariant productVariant) {
        return productVariantRepository.save(productVariant);
    }

    public List<ProductVariant> findAll() {
        return productVariantRepository.findAll();
    }

    public Optional<ProductVariant> findById(Long id) {
        return productVariantRepository.findById(id);
    }

    public void deleteById(Long id) {
        productVariantRepository.deleteById(id);
    }
}
