package ru.xpendence.generics.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 10:49
 * e-mail: 2262288@gmail.com
 */
@Entity
public class User implements Serializable {

    private Long id;
    private String name;
    private String phone;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
