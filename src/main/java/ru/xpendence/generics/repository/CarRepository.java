package ru.xpendence.generics.repository;

import org.springframework.data.repository.CrudRepository;
import ru.xpendence.generics.domain.Car;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 22:30
 * e-mail: 2262288@gmail.com
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
