package com.techhub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techhub.entities.Product;
import com.techhub.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getAllProducts(int page, int size) {
		return productRepository.findAll(PageRequest.of(page, size));
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Long id, Product updatedProduct) {
		return productRepository.findById(id).map(product -> {
			product.setName(updatedProduct.getName());
			product.setDescription(updatedProduct.getDescription());
			product.setCategory(updatedProduct.getCategory());
			return productRepository.save(product);
		}).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
