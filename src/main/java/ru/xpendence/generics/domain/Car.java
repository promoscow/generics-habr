package ru.xpendence.generics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 22:27
 * e-mail: 2262288@gmail.com
 */
@Entity
public class Car extends AbstractEntity {

    private String brand;
    private String model;

    @Column
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
