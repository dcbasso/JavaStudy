package com.dantebasso.study.redis.resources.interfaces;

import com.dantebasso.study.redis.model.Car;
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
