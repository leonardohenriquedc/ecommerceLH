package com.devleo.project.ecommerce.dto;

import com.devleo.project.ecommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    private Long id;

    @Size(min = 3, max = 80, message = "A quantidade de caracter precisa ser entre 3 e 80")
    @NotBlank
    private String name;

    @Size(min = 10, message = "Deve ter no minimo 10 caracteres")
    @NotBlank
    private String description;

    @Positive(message = "O valor deve ser positivo")
    private Double price;

    private String imgUrl;

    public ProductDto(Product entity){
        this.id = entity.getId();

        this.name = entity.getName();

        this.description = entity.getDescription();

        this.price = entity.getPrice();

        this.imgUrl = entity.getImgUrl();
    }

    public ProductDto(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDto(){
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgUrl='" + imgUrl + '\'' +
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
