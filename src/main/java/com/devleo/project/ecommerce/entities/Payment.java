package com.devleo.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@ToString

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    //Associação
    @OneToOne
    @MapsId
    private Order order;
}
