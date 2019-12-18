package application.data.entity;

import application.data.common.PersistentNamed;
import org.springframework.stereotype.Component;

@Component
public class UsersUserGroup extends PersistentNamed {
    private User user;
    private UserGroup userGroup;//list

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}
