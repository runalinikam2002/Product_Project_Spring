package com.techhub.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.techhub.entities.Category;
import com.techhub.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Page<Category> getAllCategories(int page, int size) {
		return categoryRepository.findAll(PageRequest.of(page, size));
	}

	public Optional<Category> getCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category updateCategory(Long id, Category updatedCategory) {
		return categoryRepository.findById(id).map(category -> {
			category.setName(updatedCategory.getName());
			return categoryRepository.save(category);
		}).orElseThrow(() -> new RuntimeException("Category not found"));
	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
