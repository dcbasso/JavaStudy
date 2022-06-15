package com.redis.study.RedisStudy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author Dante Basso <dcbasso@gmail.com>
 * @since 09-06-2022
 */

@RedisHash("Car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car implements Serializable {

    @Id
    private String id;

    private String name;

    private Integer year;

    private Integer model;

    private String color;

}
