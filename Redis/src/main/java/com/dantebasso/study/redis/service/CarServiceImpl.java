package com.dantebasso.study.redis.service;

import com.dantebasso.study.redis.exceptions.ObjectNotFoundException;
import com.dantebasso.study.redis.model.Car;
import com.dantebasso.study.redis.repository.CarRepository;
import com.dantebasso.study.redis.service.interfaces.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 09-06-2022
 */
@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car create(final Car car) {
        car.setId(UUID.randomUUID().toString());
        return this.carRepository.save(car);
    }

    @Override
    public Car findById(final String id) {
        Objects.requireNonNull(id);
        return this.carRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Could not found Car with ID " + id));
    }

    @Override
    public List<Car> listAll() {
        final Iterable<Car> carIterable = this.carRepository.findAll();
        final List<Car> cars = new ArrayList<Car>();
        carIterable.iterator().forEachRemaining(cars::add);
        return cars;
    }

}
