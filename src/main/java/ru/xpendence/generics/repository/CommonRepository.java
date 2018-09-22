package ru.xpendence.generics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.xpendence.generics.domain.AbstractEntity;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 9:54
 * e-mail: 2262288@gmail.com
 */
@NoRepositoryBean
public interface CommonRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {
}
