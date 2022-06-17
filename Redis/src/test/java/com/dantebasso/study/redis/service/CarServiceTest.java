package com.dantebasso.study.redis.service;

import com.dantebasso.study.redis.model.Car;
import com.dantebasso.study.redis.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 16-06-2022
 */
@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @Test
    public void insertOneCarInTheRedis() {
        final Car car = new Car();
        car.setColor("White");
        car.setModel(2022);
        car.setYear(2022);
        car.setName("Chevy");

        this.carService.create(car);

        Mockito.verify(this.carRepository, Mockito.times(1)).save(car);
    }

    @Test
    public void findOneCarInTheRedis() {
        final Car car = new Car();
        car.setId(UUID.randomUUID().toString());
        car.setColor("White");
        car.setModel(2022);
        car.setYear(2022);
        car.setName("Chevy");

        Mockito.when(this.carRepository.findById(car.getId())).thenReturn(Optional.ofNullable(car));

        final Car carFindedById = this.carService.findById(car.getId());

        Mockito.verify(this.carRepository, Mockito.times(1)).findById(Mockito.anyString());
        Assertions.assertNotNull(carFindedById);
    }

}
