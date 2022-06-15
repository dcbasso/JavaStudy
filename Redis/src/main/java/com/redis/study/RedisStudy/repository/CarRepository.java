package com.redis.study.RedisStudy.repository;

import com.redis.study.RedisStudy.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 09-06-2022
 */

@Repository
public interface CarRepository extends CrudRepository<Car, String> {
}