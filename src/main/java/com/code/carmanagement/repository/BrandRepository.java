package com.code.carmanagement.repository;

import com.code.carmanagement.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
    public Brand findFirstByName(String name);
}
