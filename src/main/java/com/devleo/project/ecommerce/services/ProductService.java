package com.devleo.project.ecommerce.services;

import com.devleo.project.ecommerce.dto.ProductDto;
import com.devleo.project.ecommerce.entities.Product;
import com.devleo.project.ecommerce.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductsRepository productsRepository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id){

        Optional<Product> result = productsRepository.findById(id);

        Product product = null;

        ProductDto productDto = null;

        if(result.isPresent()){

            product = result.get();

            productDto = new ProductDto(product);

            System.out.println("Produto encontrado, " + product.toString());
        }else{

            System.out.println("Valor não encontrado, " + id);
        }

        System.out.println("Este e o DTO: " + productDto.toString());

        return productDto;
    }

    public Page<ProductDto> findAll(Pageable pageable){

        Page<Product> result  = productsRepository.findAll(pageable);

        return result.map(x -> new ProductDto(x));
    }

    @Transactional
    public ProductDto insert (ProductDto dto){

        Product entity = new Product();

        copyDtoToEntity(entity, dto);

        entity = productsRepository.save(entity);

        return new ProductDto(entity);
    }

    @Transactional
    public ProductDto update (Long id, ProductDto dto){

        Product entity = productsRepository.getReferenceById(id);

        copyDtoToEntity(entity, dto);

        entity = productsRepository.save(entity);

        return new ProductDto(entity);
    }

    private void copyDtoToEntity(Product entity, ProductDto dto) {

        entity.setName(dto.getName());

        entity.setDescription(dto.getDescription());

        entity.setPrice(dto.getPrice());

        entity.setImgUrl(dto.getImgUrl());
    }
}
