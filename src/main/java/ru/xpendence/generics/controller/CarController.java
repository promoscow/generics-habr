package ru.xpendence.generics.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.generics.controller.common.AbstractController;
import ru.xpendence.generics.domain.Car;
import ru.xpendence.generics.service.CarService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 17:15
 * e-mail: 2262288@gmail.com
 */
@RestController
@RequestMapping("/car")
public class CarController extends AbstractController<Car, CarService> {

    public CarController(CarService service) {
        super(service);
    }
}
