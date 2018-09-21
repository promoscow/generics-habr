package ru.xpendence.generics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.generics.base.ErrorType;
import ru.xpendence.generics.domain.User;
import ru.xpendence.generics.exception.UserException;
import ru.xpendence.generics.service.UserService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 09:53
 * e-mail: 2262288@gmail.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return service.save(user).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new UserException(
                        String.format(ErrorType.USER_NOT_SAVED.getDescription(), user.toString())
                ));
    }

    @PostMapping("/all")
    public ResponseEntity<List<User>> saveAll(@RequestBody List<User> users) {
        return new ResponseEntity<>(service.saveAll(users), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return service.update(user).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new UserException(
                        String.format(ErrorType.USER_NOT_UPDATED.getDescription(), user)
                ));
    }

    @GetMapping
    public ResponseEntity<User> get(@RequestParam Long id) {
        return service.get(id).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseThrow(() -> new UserException(
                        String.format(ErrorType.USER_NOT_FOUND.getDescription(), id)
                ));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/all")
    public Boolean deleteAll() {
        return service.deleteAll();
    }
}
