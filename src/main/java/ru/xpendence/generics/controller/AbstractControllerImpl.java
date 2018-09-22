package ru.xpendence.generics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.generics.base.ErrorType;
import ru.xpendence.generics.domain.AbstractEntity;
import ru.xpendence.generics.exception.SampleException;
import ru.xpendence.generics.repository.AbstractRepository;
import ru.xpendence.generics.service.AbstractService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:15
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractControllerImpl<
        E extends AbstractEntity,
        R extends AbstractRepository<E>,
        S extends AbstractService<E, R>> implements AbstractController<E, R, S> {

    @PostMapping
    public ResponseEntity<E> save(@RequestBody E entity) {
        return getService().save(entity).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), entity.toString())
                ));
    }

    @PostMapping("/all")
    public ResponseEntity<List<E>> saveAll(@RequestBody List<E> entities) {
        return new ResponseEntity<>(getService().saveAll(entities), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<E> update(@RequestBody E entity) {
        return getService().update(entity).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_UPDATED.getDescription(), entity)
                ));
    }

    @GetMapping
    public ResponseEntity<E> get(@RequestParam Long id) {
        return getService().get(id).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

    @GetMapping("/all")
    public ResponseEntity<List<E>> getAll() {
        return new ResponseEntity<>(getService().getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id) {
        return getService().deleteById(id);
    }

    @DeleteMapping("/all")
    public Boolean deleteAll() {
        return getService().deleteAll();
    }
}
