package ru.xpendence.generics.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.generics.base.ErrorType;
import ru.xpendence.generics.domain.Car;
import ru.xpendence.generics.exception.SampleException;
import ru.xpendence.generics.repository.CarRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 22:32
 * e-mail: 2262288@gmail.com
 */
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Optional<Car> save(Car car) {
        return Optional.of(carRepository.save(car));
    }

    @Override
    public List<Car> saveAll(List<Car> cars) {
        return Lists.newArrayList(carRepository.saveAll(cars));
    }

    @Override
    public Optional<Car> update(Car car) {
        return Optional.of(carRepository.save(car));
    }

    @Override
    public Optional<Car> get(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public Boolean deleteById(Long id) {
        Car car = get(id)
                .orElseThrow(() -> new SampleException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        carRepository.delete(car);
        return !carRepository.findById(car.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        carRepository.deleteAll();
        return Lists.newArrayList(carRepository.findAll()).isEmpty();
    }
}
