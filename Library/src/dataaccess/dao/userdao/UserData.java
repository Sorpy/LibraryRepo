package dataaccess.dao.userdao;

import data.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserData {
    public static List<User> users = new ArrayList<>();
    public static Map<Long,User> userMap;

    static{
        User user1 = new User();
        user1.setUsername("UserName1");
        user1.setPassword("password1");
        user1.setUserStatus(null);
        user1.setId((long) 0);

        User user2 = new User();
        user2.setUsername("UserName3");
        user2.setPassword("password1");
        user2.setUserStatus(null);
        user2.setId((long) 1);

        User user3 = new User();
        user3.setUsername("UserName3");
        user3.setPassword("password1");
        user3.setUserStatus(null);
        user3.setId((long) 2);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        userMap = users
                .stream()
                .collect(Collectors.toMap(User::getId, item -> item));
    }
}
