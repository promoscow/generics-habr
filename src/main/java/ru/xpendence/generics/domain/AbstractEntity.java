package ru.xpendence.generics.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 9:31
 * e-mail: 2262288@gmail.com
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private Long id;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
