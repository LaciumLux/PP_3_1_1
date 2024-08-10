package web.PP_3_1_1.dao;

import web.PP_3_1_1.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void removeUserById(long id);

    void editUser(User user);

    List<User> getUsers();

    User getUserById(long id);

}

