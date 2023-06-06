package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDao;
import web.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> selectUsers(int carQuantity) {
        carQuantity = carQuantity >= 5 ? userDao.selectAllUsersFromDatabase().size() : carQuantity;
        List<User> usersForShow = userDao.selectAllUsersFromDatabase().subList(0, carQuantity);
        return usersForShow;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> selectAllUsersFromDatabase() {
        return userDao.selectAllUsersFromDatabase();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }
}