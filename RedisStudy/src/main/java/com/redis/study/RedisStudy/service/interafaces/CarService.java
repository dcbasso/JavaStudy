package com.redis.study.RedisStudy.service.interafaces;

import com.redis.study.RedisStudy.model.Car;

import java.util.Optional;

/**
 * @author Dante Basso <${company.email}>
 * @since 09-06-2022
 */
public interface CarService {

    Car create(Car car);

    Car retrieve(String id);

}
