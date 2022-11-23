package com.mojastrona.projekt_readstack.domain.api;

import com.mojastrona.projekt_readstack.domain.category.Category;
import com.mojastrona.projekt_readstack.domain.category.CategoryDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();

    public List<CategoryName> findAllCategoryNames() {
        return categoryDao.findAll()
                .stream().map(CategoryNameMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<CategoryFullInfo> findById(int categoryId) {
        return categoryDao.findById(categoryId)
                .map(CategoryFullInfoMapper::map);
    }

    private static class CategoryNameMapper {
        static CategoryName map(Category cat) {
            return new CategoryName(cat.getId(), cat.getName());
        }
    }

    private static class CategoryFullInfoMapper {
        static CategoryFullInfo map(Category cat) {
            return new CategoryFullInfo(cat.getId(), cat.getName(), cat.getDescription());
        }
    }


}
