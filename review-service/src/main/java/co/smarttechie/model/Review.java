package co.smarttechie.model;

public record Review(Long id, Long productId, String comment, Integer rating) {}