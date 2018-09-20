package ru.xpendence.generics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.generics.domain.User;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 10:52
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
