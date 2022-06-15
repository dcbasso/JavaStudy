package com.redis.study.RedisStudy.service;

import com.redis.study.RedisStudy.model.Car;
import com.redis.study.RedisStudy.service.interfaces.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 15-06-2022
 */
@Testcontainers
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarServiceIntegrationTest {

    private static final int REDIS_PORT = 6379;
    private static final String REDIS_DOCKER = "redis:6.2-alpine";

    @Autowired
    private CarService carService;

    @Container
    private static GenericContainer redis = new GenericContainer(DockerImageName.parse(REDIS_DOCKER))
            .withExposedPorts(REDIS_PORT);

    /**
     * Dynamic set host and port to connect redis.
     * Container will can start with different port to run the test, this can Dynamic adjust the connection props.
     * @param registry
     */
    @DynamicPropertySource
    public static void overriedProps(DynamicPropertyRegistry registry) {
        registry.add("spring.redis.host", redis::getHost);
        registry.add("spring.redis.port", redis::getFirstMappedPort);
    }

    @Test
    public void insertAndRetrieveOneCarWithSuccess() {
        final Car car = new Car();
        car.setColor("White");
        car.setModel(2022);
        car.setYear(2022);
        car.setName("Car One");
        final Car carCreated = this.carService.create(car);

        Assertions.assertNotNull(carCreated);
        Assertions.assertNotNull(carCreated.getId());

        final Car carRetrieved = this.carService.findById(carCreated.getId());
        Assertions.assertNotNull(carRetrieved);
        Assertions.assertNotNull(carRetrieved.getId());
        Assertions.assertEquals(carCreated.getId(), carRetrieved.getId());
    }

    @Test
    public void listCarsRetrieveOne() {
        final List<Car> cars = this.carService.listAll();

        Assertions.assertNotNull(cars);
        Assertions.assertTrue(cars.isEmpty());
    }

}
