package ru.sbt.synapse.reactproject.service;

import ru.sbt.synapse.reactproject.dto.ProductProperties;
import ru.sbt.synapse.reactproject.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getFullDescriptionInAllProducts();
//    List<ProductProperties> getShortDescriptionInAllProducts();
//    void createProduct(ProductProperties product);
//    void deleteProduct(long id);
}
