package co.smarttechie.controller;

import co.smarttechie.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final List<Product> products = List.of(
            new Product(1L, "Laptop", "High-performance laptop", 999.99),
            new Product(2L, "Smartphone", "Latest model smartphone", 699.99)
    );

    @QueryMapping
    public Product productById(@Argument Long id) {
        log.info("Get product by id: {}", id);
        return products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @QueryMapping
    public List<Product> products() {
        return products;
    }
}
