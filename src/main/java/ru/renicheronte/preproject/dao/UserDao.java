package ru.renicheronte.preproject.dao;

import ru.renicheronte.preproject.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User showUserById(int id);

    void updateUserById(User user, int id);

    void removeUserById(int id);

    List<User> getAllUsers();
}
