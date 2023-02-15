package com.code.carmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    public Car(String name, int seat, Long price, String color, Category category, Brand brand) {
        this.name = name;
        this.seat = seat;
        this.price = price;
        this.color = color;
        this.category = category;
        this.brand = brand;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "carId")
    private UUID id;

    private String name;
    private int seat;
    private Long price;
    private String color;
    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false, referencedColumnName = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brandId",nullable = false, referencedColumnName = "brandId")
    private Brand brand;



}
