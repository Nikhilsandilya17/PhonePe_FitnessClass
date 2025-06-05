package repository.impl;

import model.User;
import repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    public final Map<String, User> userDatabase;

    public UserRepositoryImpl() {
        userDatabase = new HashMap<>();
    }

    @Override
    public void saveUser(User user) {
        System.out.println("Saving user: " + user.getName());
        userDatabase.put(user.getEmail(), user);
    }

    @Override
    public User findUserById(String id) {
        return userDatabase.get(id);
    }

}
