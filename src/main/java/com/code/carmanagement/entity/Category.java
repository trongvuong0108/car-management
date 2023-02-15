package com.code.carmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    public Category(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoryId")
    private UUID id;

    private String name;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Car> cars ;
}
