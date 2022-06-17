package com.dantebasso.study.redis.service.interfaces;

import com.dantebasso.study.redis.model.Car;

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
