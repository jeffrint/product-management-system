package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    // GET all products
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // GET product by ID
    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    // ADD product with image
    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return repo.save(product);
    }

    // UPDATE product with image
    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {

        Product existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(product.getName());
            existing.setDesc(product.getDesc());
            existing.setBrand(product.getBrand());
            existing.setPrice(product.getPrice());
            existing.setCategory(product.getCategory());
            existing.setReleaseDate(product.getReleaseDate());
            existing.setAvailable(product.getAvailable());
            existing.setQuantity(product.getQuantity());

            // update image
            existing.setImageName(imageFile.getOriginalFilename());
            existing.setImageType(imageFile.getContentType());
            existing.setImageData(imageFile.getBytes());

            return repo.save(existing);
        }

        return null;
    }

    // DELETE product
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}