package ru.xpendence.generics.service;

import ru.xpendence.generics.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 09:53
 * e-mail: 2262288@gmail.com
 */
public interface UserService {

    Optional<User> save(User user);

    List<User> saveAll(List<User> users);

    Optional<User> update(User user);

    Optional<User> get(Long id);

    List<User> getAll();

    Boolean deleteById(Long id);

    Boolean deleteAll();
}
