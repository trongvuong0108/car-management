package com.code.carmanagement.service;

import com.code.carmanagement.dto.CarDTO;
import com.code.carmanagement.entity.Car;
import com.code.carmanagement.repository.BrandRepository;
import com.code.carmanagement.repository.CarRepository;
import com.code.carmanagement.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    public CarService(CarRepository carRepository, BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Car> getAll(){return carRepository.findAll();}

    public void save(Car car){
        carRepository.save(car);
    }

    public void create(CarDTO carDTO){
        Car car = new Car(
                carDTO.getName(),
                carDTO.getSeat(),
                carDTO.getPrice(),
                carDTO.getColor(),
                categoryRepository.findById(carDTO.getCategoryId()).get(),
                brandRepository.findById(carDTO.getBrandId()).get()
        );
        carRepository.save(car);
    }

    public void update(CarDTO carDTO , UUID id){
        Car car = carRepository.findById(id).get();
        if(car != null)
            carRepository.save(car);
        else// do something
            System.out.println("....");
    }
}
