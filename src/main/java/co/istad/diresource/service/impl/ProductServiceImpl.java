package co.istad.diresource.service.impl;

import co.istad.diresource.dto.ProductCreateRequest;
import co.istad.diresource.dto.ProductResponse;
import co.istad.diresource.dto.ProductEditRequest;
import co.istad.diresource.model.Category;
import co.istad.diresource.model.Product;
import co.istad.diresource.repository.CategoryRepository;
import co.istad.diresource.repository.ProductRepository;
import co.istad.diresource.service.CategoryService;
import co.istad.diresource.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final  ProductRepository productRepository;


    @Override
    public List<ProductResponse> findAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> new ProductResponse(
                        product.getUuid(),
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                )).toList();

    }

    @Override
    public List<ProductResponse> findProducts(String name, Boolean status) {

        return null;
    }

    // find product by id
    @Override
    public ProductResponse findProductById(Integer id) {
       Product product = productRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product is not found!"
                ));
        return new ProductResponse(
                product.getUuid(),
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQty()
        );
    }

    @Override
    public ProductResponse findProductByUuid(String uuid) {
        return null;
    }

    @Override
    public void createNewProduct(ProductCreateRequest request) {
        // check product gonna create hava or not
        if (productRepository.existsByName(request.name())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Product name already existed!"
            );
        }

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setQty(request.qty());

        productRepository.save(product);


    }

    @Override
    public void editProductByUuid(String uuid, ProductEditRequest request) {

    }

    @Override
    public void deleteProductById(Integer id) {
        if (!productRepository.existsById(id)){
            throw  new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Product id is  not found!"
            );
        }

        productRepository.deleteById(id);

    }

    @Override
    public ProductResponse editProductById(Integer id, ProductEditRequest request) {
       Product product = productRepository.findById(id)
               .orElseThrow(()-> new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                       "Product is not found!"
               ));
       product.setUuid(request.uuid());
       product.setName(request.name());
       product.setPrice(request.price());
       productRepository.save(product);

        return this.findProductById(id);
    }

    @Override
    public void deleteProductBYUuid(String uuid) {

    }
}
