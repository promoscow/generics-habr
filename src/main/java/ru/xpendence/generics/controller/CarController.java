package ru.xpendence.generics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.generics.base.ErrorType;
import ru.xpendence.generics.domain.Car;
import ru.xpendence.generics.exception.SampleException;
import ru.xpendence.generics.service.CarService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 22:49
 * e-mail: 2262288@gmail.com
 */
@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        return service.save(car).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), car.toString())
                ));
    }

    @PostMapping("/all")
    public ResponseEntity<List<Car>> saveAll(@RequestBody List<Car> cars) {
        return new ResponseEntity<>(service.saveAll(cars), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Car> update(@RequestBody Car car) {
        return service.update(car).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_UPDATED.getDescription(), car)
                ));
    }

    @GetMapping
    public ResponseEntity<Car> get(@RequestParam Long id) {
        return service.get(id).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/all")
    public Boolean deleteAll() {
        return service.deleteAll();
    }
}
