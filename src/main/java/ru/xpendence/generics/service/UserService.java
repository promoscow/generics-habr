package ru.xpendence.generics.service;

import org.springframework.stereotype.Service;
import ru.xpendence.generics.domain.User;
import ru.xpendence.generics.repository.UserRepository;
import ru.xpendence.generics.service.common.AbstractService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 10:23
 * e-mail: 2262288@gmail.com
 */
@Service
public class UserService extends AbstractService<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }
}
