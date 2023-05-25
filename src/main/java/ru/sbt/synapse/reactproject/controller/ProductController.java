package ru.sbt.synapse.reactproject.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sbt.synapse.reactproject.dto.ProductProperties;
import ru.sbt.synapse.reactproject.model.Product;
import ru.sbt.synapse.reactproject.service.impl.ProductServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductServiceImpl service;

    @GetMapping
    public List<Product> getProducts(){
        return service.getFullDescriptionInAllProducts();
    }


//    @PostMapping
//    public List<ProductProperties> createProduct(@RequestBody ProductProperties product){
//        service.createProduct(product);
//        return getProducts();
//    }
//
//    @DeleteMapping("{id}")
//    public List<ProductProperties> deleteProduct(@PathVariable("id") long id){
//        service.deleteProduct(id);
//        return getProducts();
//    }

}
