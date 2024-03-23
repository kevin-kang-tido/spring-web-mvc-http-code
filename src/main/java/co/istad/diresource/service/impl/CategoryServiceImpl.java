package co.istad.diresource.service.impl;

import co.istad.diresource.dto.CategoryRequest;
import co.istad.diresource.dto.CategoryResponse;
import co.istad.diresource.model.Category;
import co.istad.diresource.repository.CategoryRepository;
import co.istad.diresource.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private  final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> findCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(category -> new CategoryResponse(
                        category.getName()
                        ,category.getDescription())
                )
                .toList();
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new  ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category is not Found!"
                ));
        return new CategoryResponse(category.getName(),category.getDescription());
    }

    @Override
    public CategoryResponse findCategoryByName(String name) {


        return null;
    }

    @Override
    public void createNewCategory(CategoryRequest request) {
        // check category have or not (if have throw exception)
        if (categoryRepository.existsByName(request.name())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category name already existed!"
            );
        }
        Category category = new Category();
        // dto pattern
        category.setName(request.name());
        category.setDescription(request.description());
        // set new data to repository (function save auto insert)
        categoryRepository.save(category);

    }

    @Override
    public void deleteCategoryById(Integer id) {
        if (!categoryRepository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category has been not found!"
            );
        }
        categoryRepository.deleteById(id);

    }

    @Override
    public CategoryResponse editCategoryById(Integer id, CategoryRequest request) {
        // load old category old data
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category has been not found!!"
                ));
        category.setName(request.name());
        category.setDescription(request.description());
        categoryRepository.save(category);

        return this.findCategoryById(id);
    }

}
