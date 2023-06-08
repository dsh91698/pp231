package web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

@Component
public class AddUsersToDb {
    private UserService userService;

    @Autowired
    public AddUsersToDb(UserService userService) {
        this.userService = userService;
        userService.addUser(new User("Anand Baulk", "active", 25));
        userService.addUser(new User("Caleb Clemens", "active", 35));
        userService.addUser(new User("Noah Newton", "registered", 15));
    }

}
