package com.devleo.project.ecommerce.dto;

import com.devleo.project.ecommerce.entities.Product;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private Double price;

    public ProductDto(Product entity){
        this.id = entity.getId();

        this.name = entity.getName();

        this.description = entity.getDescription();

        this.price = entity.getPrice();
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
