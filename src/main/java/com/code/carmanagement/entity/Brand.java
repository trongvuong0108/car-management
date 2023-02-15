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
public class Brand {
    public Brand(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "brandId")
    private UUID id;

    private String name;

    private String nation;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Car> cars ;

}
