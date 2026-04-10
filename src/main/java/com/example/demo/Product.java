package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
    private LocalDate releaseDate;
    private Boolean available;
    private Integer quantity;

    // Image fields
    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;
}