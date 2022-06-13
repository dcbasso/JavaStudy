package com.redis.study.RedisStudy.service;

import com.redis.study.RedisStudy.exceptions.ObjectNotFoundException;
import com.redis.study.RedisStudy.model.Car;
import com.redis.study.RedisStudy.repository.CarRepository;
import com.redis.study.RedisStudy.service.interafaces.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Dante Basso <${company.email}>
 * @since 09-06-2022
 */
@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car create(final Car car) {
//        if (StringUtils.isNotEmpty(car.getId())) {
//            //throw
//        }
        car.setId(UUID.randomUUID().toString());

        return this.carRepository.save(car);
    }

    @Override
    public Car retrieve(final String id) {
        Objects.requireNonNull(id);
//        if (this.carRepository.findById(id).isPresent()) {
        return this.carRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Could not found Car with ID " + id));
//        return this.carRepository.retrive(id);
    }

}
