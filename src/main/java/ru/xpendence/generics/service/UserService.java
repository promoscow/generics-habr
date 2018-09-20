package ru.xpendence.generics.service;

import ru.xpendence.generics.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 10:53
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
public interface UserService {

    Optional<User> save(User user);

    List<User> saveAll(List<User> users);

    Optional<User> get(Long id);

    List<User> getAll();

    List<User> getAllById(List<Long> ids);

    Boolean deleteById(Long id);

    Boolean delete(User user);

    Boolean deleteAll(List<User> users);

    Boolean deleteAll();
}
