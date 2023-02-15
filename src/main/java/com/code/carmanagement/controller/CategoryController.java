package com.code.carmanagement.controller;

import com.code.carmanagement.dto.CarDTO;
import com.code.carmanagement.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/category")
public class CategoryController {
    private final CategoryService categoryService ;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("getAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }


}
