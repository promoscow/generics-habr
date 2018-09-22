package ru.xpendence.generics.service.common;

import com.google.common.collect.Lists;
import ru.xpendence.generics.base.ErrorType;
import ru.xpendence.generics.domain.AbstractEntity;
import ru.xpendence.generics.exception.SampleException;
import ru.xpendence.generics.repository.CommonRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 10:13
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E, R> {

    @Override
    public Optional<E> save(E entity) {
        return Optional.of(getRepository().save(entity));
    }

    @Override
    public List<E> saveAll(List<E> entities) {
        return Lists.newArrayList(getRepository().saveAll(entities));
    }

    @Override
    public Optional<E> update(E entity) {
        return Optional.of(getRepository().save(entity));
    }

    @Override
    public Optional<E> get(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public List<E> getAll() {
        return Lists.newArrayList(getRepository().findAll());
    }

    @Override
    public Boolean deleteById(Long id) {
        E entity = get(id)
                .orElseThrow(() -> new SampleException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        getRepository().delete(entity);
        return !getRepository().findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        getRepository().deleteAll();
        return Lists.newArrayList(getRepository().findAll()).isEmpty();
    }
}
