package com.code.carmanagement.service;

import com.code.carmanagement.entity.Brand;
import com.code.carmanagement.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    public List<Brand> getAll(){return brandRepository.findAll();}

    public void save(Brand brand){
        brandRepository.save(brand);
    }

    public Brand findBrandByName(String name) {return brandRepository.findFirstByName(name);}

}

