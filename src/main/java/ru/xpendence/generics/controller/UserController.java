package ru.xpendence.generics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.generics.domain.User;
import ru.xpendence.generics.service.UserService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 10:53
 * e-mail: 2262288@gmail.com
 */
@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return service.save(user).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping("/save/all")
    public ResponseEntity<List<User>> saveAll(@RequestBody List<User> users) {
        return new ResponseEntity<>(service.saveAll(users), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<User> get(@RequestParam Long id) {
        return service.get(id).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/all/ids")
    public ResponseEntity<List<User>> getAllById(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(service.getAllById(ids), HttpStatus.OK);
    }
}
