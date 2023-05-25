package ru.sbt.synapse.reactproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sbt.synapse.reactproject.dto.ProductProperties;
import ru.sbt.synapse.reactproject.exception.NotFoundProductException;
import ru.sbt.synapse.reactproject.model.Product;
import ru.sbt.synapse.reactproject.repository.ProductRepository;
import ru.sbt.synapse.reactproject.service.ProductService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;


    @Override
    public List<Product> getFullDescriptionInAllProducts() {
        return repository.findFullDescriptionInAllProducts().orElseThrow(NotFoundProductException::new);
    }

//    @Override
//    public List<ProductProperties> getShortDescriptionInAllProducts() {
//        return repository.findShortDescriptionInAllProducts().orElseThrow(NotFoundProductException::new);
//    }
//
//    @Override
//    public void createProduct(ProductProperties product) {
//        repository.saveProduct(product.getName(), product.getNumber());
//    }
//
//    @Override
//    public void deleteProduct(long id) {
//        repository.deleteProductByProductId(id);
//    }
}
