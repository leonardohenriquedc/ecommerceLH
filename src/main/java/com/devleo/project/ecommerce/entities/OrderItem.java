package com.devleo.project.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

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

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }
}
