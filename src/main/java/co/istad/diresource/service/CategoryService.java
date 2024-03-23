package co.istad.diresource.service;


import co.istad.diresource.dto.CategoryRequest;
import co.istad.diresource.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findCategories();
    CategoryResponse findCategoryById(Integer id);
    CategoryResponse findCategoryByName(String name);
    void createNewCategory(CategoryRequest request);
    void deleteCategoryById(Integer id);
    CategoryResponse editCategoryById(Integer id, CategoryRequest request);




}
