package co.smarttechie.controller;

import co.smarttechie.model.Product;
import co.smarttechie.model.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.federation.EntityMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ReviewController {
    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
    private final List<Review> reviews = List.of(
            new Review(1L, 1L, "Great laptop!", 5),
            new Review(2L, 1L, "Battery life could be better.", 4),
            new Review(3L, 2L, "Amazing phone!", 5)
    );

    @EntityMapping
    public Product product(@Argument Long id) {
        return new Product(id);
    }

    @SchemaMapping
    public List<Review> reviews(Product product) {
        log.info("Get reviews for {}", product);
        return reviews.stream()
                .filter(r -> r.productId().equals(product.id()))
                .toList();
    }
}
