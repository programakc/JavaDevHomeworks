package ru.klgd.javadev.homework19.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "televisions", schema = "tv")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String company;

    private String model;

    private Integer release;

    private Double price;

    @Column(name = "in_stock")
    private Integer countInStock;

}
