package dao;

import model.User;

public interface UserDao {
    String FindPasswordByUsername(String Username);
    void insertUser(User user);
    void updateUser(User user);
    User selectUserByUsername(String username);
}
