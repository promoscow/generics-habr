package ru.xpendence.generics.repository;

import org.springframework.stereotype.Repository;
import ru.xpendence.generics.domain.User;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 17:06
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface UserRepository extends AbstractRepository<User> {
}
