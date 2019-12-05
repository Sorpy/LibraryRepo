package application.data.entity;

import org.springframework.stereotype.Component;

@Component
public class UserGroup extends Persistent {
    private UserGroupStatus userGroupStatus;

    public UserGroupStatus getUserGroupStatus() {
        return userGroupStatus;
    }

    public void setUserGroupStatus(UserGroupStatus userGroupStatus) {
        this.userGroupStatus = userGroupStatus;
    }
}
