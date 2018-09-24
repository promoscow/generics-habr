package ru.xpendence.generics.service;

import org.springframework.stereotype.Service;
import ru.xpendence.generics.domain.Car;
import ru.xpendence.generics.repository.CarRepository;
import ru.xpendence.generics.service.common.AbstractService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 17:13
 * e-mail: 2262288@gmail.com
 */
@Service
public class CarService extends AbstractService<Car, CarRepository> {

    public CarService(CarRepository repository) {
        super(repository);
    }
}