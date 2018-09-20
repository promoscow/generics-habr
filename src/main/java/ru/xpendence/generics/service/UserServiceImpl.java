package ru.xpendence.generics.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.generics.domain.User;
import ru.xpendence.generics.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 11:05
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return Lists.newArrayList(userRepository.saveAll(users));
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public List<User> getAllById(List<Long> ids) {
        return Lists.newArrayList(userRepository.findAllById(ids));
    }

    @Override
    public Boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return !userRepository.findById(id).isPresent();
    }

    @Override
    public Boolean delete(User user) {
        userRepository.delete(user);
        return !userRepository.findById(user.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll(List<User> users) {
        userRepository.deleteAll(users);
        return Lists.newArrayList(userRepository.findAllById(users.stream().map(User::getId).collect(Collectors.toList()))).isEmpty();
    }

    @Override
    public Boolean deleteAll() {
        userRepository.deleteAll();
        return Lists.newArrayList(userRepository.findAll()).isEmpty();
    }
}
