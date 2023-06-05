package web.service;

import web.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    static List<User> carList = new ArrayList<>();
    static {
        carList.add(new User("Kevin", "active", 1975));
        carList.add(new User( "Noah", "banned", 1985));
        carList.add(new User("Bobby", "read-only", 1995));
        carList.add(new User( "Caleb", "active", 2005));
        carList.add(new User("John", "registered", 2015));
    }


    @Override
    public List<User> selectUsers(int carQuantity) {
        carQuantity = carQuantity >= 5 ? carList.size()  : carQuantity;
        List<User> carsForShow = carList.subList(0, carQuantity);
        return carsForShow;
    }
}