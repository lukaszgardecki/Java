package com.example.jparelacje2.domain.category;

import com.example.jparelacje2.Mapper;
import com.example.jparelacje2.exception.CategoryNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
        Category categoryToSave = new Category();
        categoryToSave.setName(categoryRequestDto.getName());
        Category savedCategory = categoryRepository.save(categoryToSave);
        return Mapper.mapCategoryToCategoryResponseDto(savedCategory);
    }

    public CategoryResponseDto getCategory(Long categoryId) {
        Category category = findCategoryById(categoryId);
        return Mapper.mapCategoryToCategoryResponseDto(category);
    }

    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(Mapper::mapCategoryToCategoryResponseDto)
                .toList();
    }

    @Transactional
    public CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto) {
        Category categoryToUpdate = findCategoryById(categoryId);
        categoryToUpdate.setName(categoryRequestDto.getName());
        return Mapper.mapCategoryToCategoryResponseDto(categoryToUpdate);
    }

    @Transactional
    public CategoryResponseDto deleteCategory(Long categoryId) {
        Category categoryToDelete = findCategoryById(categoryId);
        categoryRepository.delete(categoryToDelete);
        return Mapper.mapCategoryToCategoryResponseDto(categoryToDelete);
    }


    private Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new);
    }
}
