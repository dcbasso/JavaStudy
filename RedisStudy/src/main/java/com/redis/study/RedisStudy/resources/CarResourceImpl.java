package com.redis.study.RedisStudy.resources;

import com.redis.study.RedisStudy.model.Car;
import com.redis.study.RedisStudy.resources.interfaces.CarResource;
import com.redis.study.RedisStudy.service.interafaces.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 09-06-2022
 */

@RestController
@RequestMapping(value = "/cars")
@AllArgsConstructor
public class CarResourceImpl implements CarResource {

    private CarService carService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Car> create(final @RequestBody Car car) {
        final Car newCar = this.carService.create(car);
        return ResponseEntity.ok(newCar);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Car> retrieve(@PathVariable final String id) {
        final Car retrieved = this.carService.retrieve(id);
        return ResponseEntity.ok(retrieved);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Car>> listAll() {
        final List<Car> cars = this.carService.listAll();
        return ResponseEntity.ok(cars);
    }

}
