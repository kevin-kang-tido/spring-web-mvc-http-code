package co.istad.diresource.service.impl;

import co.istad.diresource.dto.ProductCreateRequest;
import co.istad.diresource.dto.ProductDto;
import co.istad.diresource.dto.ProductEditRequest;
import co.istad.diresource.model.Product;
import co.istad.diresource.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setUuid(UUID.randomUUID().toString());
        p1.setName("iPhone 14 Pro Max");
        p1.setPrice(1300.0);
        p1.setQty(1);
        p1.setImportDate(LocalDateTime.now());
        p1.setStatus(true);
        Product p2 = new Product();
        p2.setId(2);
        p2.setUuid(UUID.randomUUID().toString());
        p2.setName("macBook M3 RAM 30GB");
        p2.setPrice(2600.0);
        p2.setQty(2);
        p2.setImportDate(LocalDateTime.now());
        p2.setStatus(true);
        Product p3 = new Product();
        p3.setId(3);
        p3.setUuid(UUID.randomUUID().toString());
        p3.setName("macBook M3 RAM 30GB");
        p3.setPrice(2600.0);
        p3.setQty(2);
        p3.setImportDate(LocalDateTime.now());
        p3.setStatus(true);
        products.add(p1);
        products.add(p2);
        products.add(p3);
    }

    @Override
    public List<ProductDto> findProducts(String name, Boolean status) {
        return products.stream()
                .filter(Product::getStatus)
                .map(product -> new ProductDto(
                        product.getUuid(),
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .toList()
        ;
    }

    @Override
    public ProductDto findProductById(Integer id) {
        return products.stream()
                .filter(product -> product.getId().equals(id) &&
                        product.getStatus().equals(true))
                .map(product -> new ProductDto(
                        product.getUuid(),
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .findFirst()
                .orElseThrow();

    }


    @Override
    public ProductDto findProductByUuid(String uuid) {
        return products.stream()
                .filter(product -> product.getUuid().equals(uuid) &&
                        product.getStatus().equals(true))
                .map(product -> new ProductDto(
                        product.getUuid(),
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .findFirst()
                .orElseThrow();

    }

    // create new products
    @Override
    public void createNewProduct(ProductCreateRequest request) {
        Product newProduct = new Product();
        newProduct.setName(request.name());
        newProduct.setPrice(request.price());
        newProduct.setQty(request.qty());
        newProduct.setId(products.size() +1 );
        newProduct.setUuid(UUID.randomUUID().toString());
        newProduct.setImportDate(LocalDateTime.now());
        newProduct.setStatus(true);
        products.add(newProduct);
    }

    // override for edit user by uuid
    @Override
    public void editProductByUuid(String uuid, ProductEditRequest request) {
        // check the uuid have or not
       long count =  products.stream()
               .filter(product -> product.getUuid().equals(uuid))
               .peek(oldProduct -> {
                   oldProduct.setName(request.name());
                   oldProduct.setPrice(request.price());
               }).count();
        System.out.println("Affected row : "+count);
    }

    @Override
    public boolean deleteProductById(Integer id) {
        
        return products.removeIf(product -> product.getId().equals(id));
    }

}
