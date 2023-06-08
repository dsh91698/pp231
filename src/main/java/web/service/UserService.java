package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user); //create

    User getById(Long id); //read

    List<User> selectAllUsersFromDatabase(); //read

    void updateUser(User user, Long id); //update

    void deleteById(Long id); //delete


}
