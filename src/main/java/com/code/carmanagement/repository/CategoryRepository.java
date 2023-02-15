package com.code.carmanagement.repository;

import com.code.carmanagement.entity.Brand;
import com.code.carmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    public Category findFirstByName(String name);
}
