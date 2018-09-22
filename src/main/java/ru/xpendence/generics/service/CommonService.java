package ru.xpendence.generics.service;

import ru.xpendence.generics.domain.AbstractEntity;
import ru.xpendence.generics.repository.CommonRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 10:01
 * e-mail: 2262288@gmail.com
 */
public interface CommonService<E extends AbstractEntity, R extends CommonRepository<E>> {

    R getRepository();

    Optional<E> save(E entity);

    List<E> saveAll(List<E> entities);

    Optional<E> update(E entity);

    Optional<E> get(Long id);

    List<E> getAll();

    Boolean deleteById(Long id);

    Boolean deleteAll();
}
