package com.devleo.project.ecommerce.controllers;

import com.devleo.project.ecommerce.dto.CustomError;
import com.devleo.project.ecommerce.dto.ProductDto;
import com.devleo.project.ecommerce.services.ProductService;
import com.devleo.project.ecommerce.services.exceptions.ResourceNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@Getter
@Setter

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

   @Autowired
   private ProductService productsService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id){

        ProductDto dto = productsService.findById(id);

        return ResponseEntity.ok(dto);

    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable){

        Page<ProductDto> result = productsService.findAll(pageable);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ProductDto> insert (@RequestBody ProductDto dto){
        dto = productsService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> update (@PathVariable Long id, @RequestBody ProductDto dto){

        dto = productsService.update(id, dto);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        productsService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
