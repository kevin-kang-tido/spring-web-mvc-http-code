package co.istad.diresource.service;

import co.istad.diresource.dto.ProductCreateRequest;
import co.istad.diresource.dto.ProductResponse;
import co.istad.diresource.dto.ProductEditRequest;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findAllProducts();
    List<ProductResponse> findProducts(String name, Boolean status);
    ProductResponse findProductById(Integer id);

    ProductResponse findProductByUuid(String uuid);

    void createNewProduct(ProductCreateRequest request);

    // edit user by uuid
    // Product Edit Request we get it from dto productEdiRequest
    void  editProductByUuid(String uuid, ProductEditRequest request );

    void deleteProductById(Integer id);
    ProductResponse editProductById(Integer id,ProductEditRequest request);
    void deleteProductBYUuid(String uuid);



}
