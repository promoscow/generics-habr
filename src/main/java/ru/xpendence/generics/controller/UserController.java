package ru.xpendence.generics.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.generics.controller.common.AbstractController;
import ru.xpendence.generics.domain.User;
import ru.xpendence.generics.service.UserService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:22
 * e-mail: 2262288@gmail.com
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserService> {

    public UserController(UserService service) {
        super(service);
    }
}
