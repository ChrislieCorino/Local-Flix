package com.localflix.model;

public record Movie(Long id, String title, String description, String genre, String category,
                    String year, String rating, String duration, String poster, String trailer,
                    boolean featured) {}
