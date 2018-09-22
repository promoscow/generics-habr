package ru.xpendence.generics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xpendence.generics.controller.common.AbstractController;
import ru.xpendence.generics.domain.User;
import ru.xpendence.generics.repository.UserRepository;
import ru.xpendence.generics.service.UserService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:22
 * e-mail: 2262288@gmail.com
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserRepository, UserService> {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    public UserService getService() {
        return service;
    }
}
