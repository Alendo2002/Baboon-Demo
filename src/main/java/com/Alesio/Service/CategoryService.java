package com.Alesio.Service;

import com.Alesio.model.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory (String name, Long userId) throws Exception;

    public List<Category> findByCategoryByRestaurantId(Long id) throws Exception;

    public Category findCategoryById(Long id) throws Exception;
}
