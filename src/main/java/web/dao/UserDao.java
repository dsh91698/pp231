package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    //CRUD
    void addUser(User user); //create

    User getById(Long id); //read

    List<User> selectAllUsersFromDatabase(); //read

    void updateUser(User user, Long id); //update

    void deleteById(Long id); //delete
}
