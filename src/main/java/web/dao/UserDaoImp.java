package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    public static int COUNTER = 0;
    public List<User> userList = new ArrayList<>();

    public UserDaoImp() {
        userList.add(new User((long) ++COUNTER, "Kevin", "active", 95));
        userList.add(new User((long) ++COUNTER, "Noah", "banned", 85));
        userList.add(new User((long) ++COUNTER, "Bobby", "read-only", 75));
        userList.add(new User((long) ++COUNTER, "Caleb", "active", 65));
        userList.add(new User((long) ++COUNTER, "John", "registered", 55));
    }

    @Override
    public void addUser(User user) {
        user.setId((long) ++COUNTER);
        userList.add(user);


    }

    @Override
    public User getById(Long id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null); // if User with the specified ID was not found
    }


    @Override
    public List<User> selectAllUsersFromDatabase() {
        return userList;
    }

    @Override
    public void updateUser(User userUpdated, Long id) {
        User user = getById(id);
        user.setUserName(userUpdated.getUserName());
        user.setUserAge(userUpdated.getUserAge());
        user.setUserStatus(userUpdated.getUserStatus());
    }

    @Override
    public void deleteById(Long id) {
        userList.removeIf(user -> user.getId() == id);
    }
}