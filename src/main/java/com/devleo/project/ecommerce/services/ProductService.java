package com.devleo.project.ecommerce.services;

import com.devleo.project.ecommerce.dto.ProductDto;
import com.devleo.project.ecommerce.entities.Product;
import com.devleo.project.ecommerce.repositories.ProductsRepository;
import com.devleo.project.ecommerce.services.exceptions.DataBaseException;
import com.devleo.project.ecommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductsRepository productsRepository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id){

        Product result = productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));


        return new ProductDto(result);
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



        try {

            Product entity = productsRepository.getReferenceById(id);

            copyDtoToEntity(entity, dto);

            entity = productsRepository.save(entity);

            return new ProductDto(entity);

        }catch (EntityNotFoundException e){

             throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){

        if(!productsRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try{
            productsRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){

            throw new DataBaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(Product entity, ProductDto dto) {

        entity.setName(dto.getName());

        entity.setDescription(dto.getDescription());

        entity.setPrice(dto.getPrice());

        entity.setImgUrl(dto.getImgUrl());
    }
}
