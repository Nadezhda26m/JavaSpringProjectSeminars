package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductsController {

    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product product, Model model) {
        productService.addProduct(product);
        model.addAttribute("products", productService.findAll());
        return "products";
    }
}
