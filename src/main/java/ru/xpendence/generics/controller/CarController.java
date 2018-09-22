package ru.xpendence.generics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xpendence.generics.domain.Car;
import ru.xpendence.generics.repository.CarRepository;
import ru.xpendence.generics.service.CarService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 17:15
 * e-mail: 2262288@gmail.com
 */
@Controller
@RequestMapping("/car")
public class CarController extends AbstractControllerImpl<Car, CarRepository, CarService> {

    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @Override
    public CarService getService() {
        return service;
    }
}
