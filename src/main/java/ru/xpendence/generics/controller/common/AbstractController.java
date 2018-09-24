package ru.xpendence.generics.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.xpendence.generics.base.ErrorType;
import ru.xpendence.generics.domain.AbstractEntity;
import ru.xpendence.generics.exception.SampleException;
import ru.xpendence.generics.service.common.CommonService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:15
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>>
        implements CommonController<E> {

    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<E> save(@RequestBody E entity) {
        return service.save(entity).map(ResponseEntity::ok)
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), entity.toString())
                ));
    }

    @Override
    public ResponseEntity<List<E>> saveAll(@RequestBody List<E> entities) {
        return ResponseEntity.ok(service.saveAll(entities));
    }

    @Override
    public ResponseEntity<E> update(@RequestBody E entity) {
        return service.update(entity).map(ResponseEntity::ok)
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_UPDATED.getDescription(), entity)
                ));
    }

    @Override
    public ResponseEntity<E> get(@RequestParam Long id) {
        return service.get(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

    @Override
    public ResponseEntity<List<E>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    public Boolean delete(@RequestParam Long id) {
        return service.deleteById(id);
    }

    @Override
    public Boolean deleteAll() {
        return service.deleteAll();
    }
}
