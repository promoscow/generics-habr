package ru.xpendence.generics.service;

import ru.xpendence.generics.domain.Car;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 22:31
 * e-mail: 2262288@gmail.com
 */
public interface CarService {

    Optional<Car> save(Car car);

    List<Car> saveAll(List<Car> cars);

    Optional<Car> update(Car car);

    Optional<Car> get(Long id);

    List<Car> getAll();

    Boolean deleteById(Long id);

    Boolean deleteAll();
}
