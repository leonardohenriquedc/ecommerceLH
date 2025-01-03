package com.devleo.project.ecommerce.controllers;

import com.devleo.project.ecommerce.dto.ProductDto;
import com.devleo.project.ecommerce.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

   @Autowired
   private ProductService productsService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ProductDto findById(@PathVariable Long id){

        return productsService.findById(id);
    }

    @GetMapping
    public Page<ProductDto> findAll(Pageable pageable){

        Page<ProductDto> result = productsService.findAll(pageable);

        return result;
    }
}
