package ru.sbt.synapse.reactproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.sbt.synapse.reactproject.dto.ProductProperties;
import ru.sbt.synapse.reactproject.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "select * from react_market.products products")
    Optional<List<Product>> findFullDescriptionInAllProducts();

//    @Query(nativeQuery = true, value = "select * from react_market.products products")
//    Optional<List<ProductProperties>> findShortDescriptionInAllProducts();
//
//    @Query(nativeQuery = true, value = "select * from react_market.products products where products.id = ?1")
//    Optional<Product> findProductById(long id);
//
//    @Modifying
//    @Query(nativeQuery = true, value = "insert into react_market.products(name, number)"+
//    " values (:name, :number)")
//    void saveProduct(@Param("name") String name, @Param("number") int number);
//
//    @Modifying
//    @Query(nativeQuery = true, value = "delete from react_market.products product where product.id = ?1")
//    void deleteProductByProductId(long id);

}
