package co.istad.diresource.service;

import co.istad.diresource.dto.ProductCreateRequest;
import co.istad.diresource.dto.ProductDto;
import co.istad.diresource.dto.ProductEditRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    List<ProductDto> findProducts(String name, Boolean status);
    ProductDto findProductById(Integer id);

    ProductDto findProductByUuid(String uuid);

    void createNewProduct(ProductCreateRequest request);

    // edit user by uuid
    // Product Edit Request we get it from dto productEdiRequest
    void  editProductByUuid(String uuid, ProductEditRequest request );

    boolean deleteProductById(Integer id);
    void deleteProductBYUuid(String uuid);



}
