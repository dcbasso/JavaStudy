package com.redis.study.RedisStudy.service;

import com.redis.study.RedisStudy.exceptions.ObjectNotFoundException;
import com.redis.study.RedisStudy.model.Car;
import com.redis.study.RedisStudy.repository.CarRepository;
import com.redis.study.RedisStudy.service.interafaces.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public Car retrieve(final String id) {
        Objects.requireNonNull(id);
        return this.carRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Could not found Car with ID " + id));
    }

    @Override
    public List<Car> listAll() {
        final Iterable<Car> carIterable = this.carRepository.findAll();
        final List<Car> cars = new ArrayList<Car>();
//        for (Car car : carIterable) {
//            cars.add(car);
//        }
        carIterable.iterator().forEachRemaining(cars::add);
        return cars;
    }

}
