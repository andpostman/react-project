package ru.sbt.synapse.reactproject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sbt.synapse.reactproject.dto.ProductProperties;

import java.util.List;

@FeignClient(value = "product-page", url = "${main-page.url}")
@RequestMapping("/products")
public interface ProductClient {

    @GetMapping
    List<ProductProperties> getProducts();
}
