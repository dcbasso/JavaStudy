package com.redis.study.RedisStudy.service.interfaces;

import com.redis.study.RedisStudy.model.Car;

import java.util.List;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 09-06-2022
 */
public interface CarService {

    Car create(Car car);

    Car findById(String id);

    List<Car> listAll();

}
