package com.example.jparelacje2.web;

import com.example.jparelacje2.domain.category.CategoryRequestDto;
import com.example.jparelacje2.domain.category.CategoryResponseDto;
import com.example.jparelacje2.domain.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryRequestDto request) {
        CategoryResponseDto savedCategory = categoryService.addCategory(request);

        URI savedCategoryURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCategory.getId())
                .toUri();

        return ResponseEntity.created(savedCategoryURI).body(savedCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        CategoryResponseDto category = categoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        List<CategoryResponseDto> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable Long id) {
        CategoryResponseDto removedCategory = categoryService.deleteCategory(id);
        return ResponseEntity.ok(removedCategory);
    }

    @PostMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> editCategory(@PathVariable Long id, @RequestBody CategoryRequestDto request) {
        CategoryResponseDto editedCategory = categoryService.editCategory(id, request);
        return ResponseEntity.ok(editedCategory);
    }


}
