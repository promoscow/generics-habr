package ru.xpendence.generics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 09:49
 * e-mail: 2262288@gmail.com
 */
@Entity
public class User extends AbstractEntity {

    private String name;
    private String phone;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
