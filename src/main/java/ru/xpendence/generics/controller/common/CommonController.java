package ru.xpendence.generics.controller.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.generics.domain.AbstractEntity;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:10
 * e-mail: 2262288@gmail.com
 */
public interface CommonController<
        E extends AbstractEntity> {

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);

    @PostMapping("/all")
    ResponseEntity<List<E>> saveAll(@RequestBody List<E> entities);

    @PutMapping
    ResponseEntity<E> update(@RequestBody E entity);

    @GetMapping
    ResponseEntity<E> get(@RequestParam Long id);

    @GetMapping("/all")
    ResponseEntity<List<E>> getAll();

    @DeleteMapping
    Boolean delete(@RequestParam Long id);

    @DeleteMapping("/all")
    Boolean deleteAll();
}
