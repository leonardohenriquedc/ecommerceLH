package com.devleo.project.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @Setter
    @Getter
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;

    private Double price;

    public Order getOrder(){
        return this.getId().getOrder();
    }

    public void setOrder(Order order){
        this.getId().setOrder(order);
    }

    public Product getProduct(){
        return this.getId().getProduct();
    }

    public void setProduct(Product product){
        this.getId().setProduct(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
