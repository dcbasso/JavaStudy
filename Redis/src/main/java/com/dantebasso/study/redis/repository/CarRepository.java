package com.dantebasso.study.redis.repository;

import com.dantebasso.study.redis.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 09-06-2022
 */

@Repository
public interface CarRepository extends CrudRepository<Car, String> {
}