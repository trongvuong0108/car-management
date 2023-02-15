package com.code.carmanagement;

import com.code.carmanagement.entity.Brand;
import com.code.carmanagement.entity.Car;
import com.code.carmanagement.entity.Category;
import com.code.carmanagement.service.BrandService;
import com.code.carmanagement.service.CarService;
import com.code.carmanagement.service.CategoryService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", description = "Employees Information"))
public class CarManagementApplication {

    private final CarService carService;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public CarManagementApplication(CarService carService, BrandService brandService, CategoryService categoryService) {
        this.carService = carService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarManagementApplication.class, args);
    }



    @PostConstruct
    public void dataSeeding() {
        List<Car> cars = carService.getAll();
        List<Brand> brands= brandService.getAll();
        List<Category> categories = categoryService.getAll();
        if (brands.isEmpty()) {
            brandService.save(new Brand("BMW", "Germany"));
            brandService.save(new Brand("Mercedes", "Germany"));
            brandService.save(new Brand("Mazda", "Japan"));
            brandService.save(new Brand("Toyota", "Japan"));
            brandService.save(new Brand("Honda", "Japan"));
            brandService.save(new Brand("Hyundai", "Korea"));
            brandService.save(new Brand("VinFast", "VietNam"));
        }
        if (categories.isEmpty()) {
            categoryService.save(new Category("SUV"));
            categoryService.save(new Category("CUV"));
            categoryService.save(new Category("Sedan"));
            categoryService.save(new Category("Micro"));
        }
        if (cars.isEmpty()) {
            carService.save(new Car("Mercedes GLC 300",5, 3000000000L,"white",categoryService.findCategoriesByName("SUV"),brandService.findBrandByName("Mercedes")));
            carService.save(new Car("Mercedes GLC 250",5, 2500000000L,"white",categoryService.findCategoriesByName("SUV"),brandService.findBrandByName("Mercedes")));
            carService.save(new Car("Mercedes C300",5, 2000000000L,"white",categoryService.findCategoriesByName("Sedan"),brandService.findBrandByName("Mercedes")));
            carService.save(new Car("Mercedes E300",5, 2300000000L,"white",categoryService.findCategoriesByName("Sedan"),brandService.findBrandByName("Mercedes")));
            carService.save(new Car("BMW 320i Sport line",5, 1400000000L,"white",categoryService.findCategoriesByName("Sedan"),brandService.findBrandByName("BMW")));
            carService.save(new Car("BMW 430i Convertible MSport",5, 3400000000L,"white",categoryService.findCategoriesByName("Sedan"),brandService.findBrandByName("BMW")));
        }
    }
}
