package co.istad.diresource.controller;

import co.istad.diresource.dto.ProductCreateRequest;
import co.istad.diresource.dto.ProductEditRequest;
import co.istad.diresource.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private  final ProductService productService;

    @GetMapping
    ResponseEntity<?> findProducts(@RequestParam(required = false, defaultValue = "") String name,
                                   @RequestParam(required = false, defaultValue = "true") Boolean status) {
        return new ResponseEntity<>(
                Map.of(
                        "message", "Products have been found",
                        "data", productService.findProducts(name, status)
                ),HttpStatus.ACCEPTED
        );

    }





//    Map<String, Object> findProducts(@RequestParam(required = false, defaultValue = "") String name,
//                                         @RequestParam(required = false, defaultValue = "true") Boolean status) {
//        return Map.of(
//                "message", "Products have been found",
//                "data", productService.findProducts(name, status)
//        );
//    }

    @GetMapping("/{id}")
    Map<String, Object> findProductById(@PathVariable Integer id) {
        return Map.of(
                "message", "Product has been found",
                "data", productService.findProductById(id)
        );
    }

    @GetMapping("/uuid/{uuid}")
    Map<String, Object> findProductByUuid(@PathVariable String uuid) {
        return Map.of(
                "message", "Product has been found",
                "data", productService.findProductByUuid(uuid)
        );
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
        void createNewProduct(@Valid @RequestBody ProductCreateRequest request) {
            System.out.println("REQUEST: " + request);
            productService.createNewProduct(request);

       }


    // controller for edit product by uuid
    @PutMapping("/uuid/{uuid}")
    void editProductByUuid(@PathVariable String uuid, @RequestBody ProductEditRequest request){
        productService.editProductByUuid(uuid,request);

    }
    @DeleteMapping("/delete/{id}")
    Boolean deleteProductById(@PathVariable Integer id){
        return productService.deleteProductById(id);
    }
    // testing delete by uuid 
    @DeleteMapping("/delete/uuid/{uuid}")
    void deleteProductByUuid(@PathVariable String uuid){
        productService.deleteProductBYUuid(uuid);

    }



}
