package ru.xpendence.generics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.generics.domain.User;
import ru.xpendence.generics.repository.UserRepository;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 10:23
 * e-mail: 2262288@gmail.com
 */
@Service
public class UserService extends AbstractService<User, UserRepository> {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserRepository getRepository() {
        return repository;
    }
}
