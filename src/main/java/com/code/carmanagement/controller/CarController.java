package com.code.carmanagement.controller;

import com.code.carmanagement.dto.CarDTO;
import com.code.carmanagement.entity.Car;
import com.code.carmanagement.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/car")
public class    CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("getAll")
    public List<Car> getAll(){
        return carService.getAll();
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody CarDTO carDTO){
        carService.create(carDTO);
        return new ResponseEntity<>("create is successful", HttpStatus.OK);
    }

    @PostMapping("update/id={id}")
    public ResponseEntity<?> update(@RequestBody CarDTO carDTO , @PathVariable UUID id){
        carService.update(carDTO,id);
        return new ResponseEntity<>("update is successful", HttpStatus.OK);
    }
}
