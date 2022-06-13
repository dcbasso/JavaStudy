package com.redis.study.RedisStudy.resources.interfaces;

import com.redis.study.RedisStudy.model.Car;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 09-06-2022
 */
public interface CarResource {

    ResponseEntity<Car> create(final Car car);

    ResponseEntity<Car> retrieve(final String id);

    ResponseEntity<List<Car>> listAll();

}
