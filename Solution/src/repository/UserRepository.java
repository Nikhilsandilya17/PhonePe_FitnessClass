package repository;

import model.User;

public interface UserRepository {
    void saveUser(User user);
    User findUserById(String id);

}
