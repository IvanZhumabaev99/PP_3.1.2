package ru.zhumabaev.springcourse.PP311.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zhumabaev.springcourse.PP311.model.User;
import ru.zhumabaev.springcourse.PP311.repositories.UsersRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    } //getAllUsers()

    @Override
    @Transactional
    public void addUser(User user) {
        usersRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> foundUser = usersRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Override
    @Transactional
    public User updateUser(User updatedUser, int id) {
        usersRepository.save(updatedUser);
        return updatedUser;
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }
}
