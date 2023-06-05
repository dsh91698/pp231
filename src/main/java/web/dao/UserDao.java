package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.Collection;
import java.util.List;

public interface UserDao {

    //CRUD
    void addUser(User user); //create

    User getById(Long id); //read

    List<User> selectAllUsersFromDatabase(); //read

    void updateUser(User user); //update

    void deleteById(Long id); //delete
}
