package co.istad.diresource.controller;

import co.istad.diresource.dto.ProductCreateRequest;
import co.istad.diresource.dto.ProductEditRequest;
import co.istad.diresource.dto.ProductResponse;
import co.istad.diresource.model.Product;
import co.istad.diresource.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content) })
    @GetMapping
    ResponseEntity<?> findProducts(){
        return ResponseEntity.accepted().body(
                Map.of(
                        "Data","Data is found!",
                        "Products",productService.findAllProducts()
                )
        );

    }
    // not yet do with this method
//    @GetMapping("/{name}")
//    ResponseEntity<?> findProductByName(@RequestParam(required = false, defaultValue = "") String name,
//                                   @RequestParam(required = false, defaultValue = "true") Boolean status) {
//        return new ResponseEntity<>(
//                Map.of(
//                        "message", "Products have been found",
//                        "data", productService.findProducts(name, status)
//                ),HttpStatus.ACCEPTED
//        );
//    }

    @Operation(summary = "create new product")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewProduct(@Valid @RequestBody ProductCreateRequest request) {
        System.out.println("REQUEST: " + request);
        productService.createNewProduct(request);

    }
    //    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Find Product by id")
    @GetMapping("/{id}")
    ProductResponse findProductById(@PathVariable Integer id) {
        return  productService.findProductById(id);
    }
    @Operation(summary = "edit product by id")
    @PostMapping("/{id}")
    ProductResponse editProductById(@PathVariable Integer id,ProductEditRequest request){
        return productService.editProductById(id,request);
    }

    @Operation(summary = "delete product by id")
    @DeleteMapping("/{id}")
    void deleteProductById(@PathVariable Integer id){
        productService.deleteProductById(id);
    }













//    Map<String, Object> findProducts(@RequestParam(required = false, defaultValue = "") String name,
//                                         @RequestParam(required = false, defaultValue = "true") Boolean status) {
//        return Map.of(
//                "message", "Products have been found",
//                "data", productService.findProducts(name, status)
//        );
//    }



//    @GetMapping("/uuid/{uuid}")
//    Map<String, Object> findProductByUuid(@PathVariable String uuid) {
//        return Map.of(
//                "message", "Product has been found",
//                "data", productService.findProductByUuid(uuid)
//        );
//    }



    // controller for edit product by uuid
//    @PutMapping("/uuid/{uuid}")
//    void editProductByUuid(@PathVariable String uuid, @RequestBody ProductEditRequest request){
//        productService.editProductByUuid(uuid,request);
//
//    }

    // testing delete by uuid 
//    @DeleteMapping("/delete/uuid/{uuid}")
//    void deleteProductByUuid(@PathVariable String uuid){
//        productService.deleteProductBYUuid(uuid);
//
//    }



}
