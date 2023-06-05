package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao{

    public List<User> userList = new ArrayList<>();

    public UserDaoImp() {
            userList.add(new User("Kevin", "active", 95));
            userList.add(new User( "Noah", "banned", 85));
            userList.add(new User("Bobby", "read-only", 75));
            userList.add(new User( "Caleb", "active", 65));
            userList.add(new User("John", "registered", 55));
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public List<User> selectAllUsersFromDatabase() {
        return userList;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }
}