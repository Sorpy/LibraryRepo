package business.converter.usergroup;

import business.converter.BaseParam;
import data.entity.UserGroupStatus;

public class UserGroupParam extends BaseParam {
    private UserGroupStatus userGroupStatus;

    public UserGroupStatus getUserGroupStatus() {
        return userGroupStatus;
    }

    public void setUserGroupStatus(UserGroupStatus userGroupStatus) {
        this.userGroupStatus = userGroupStatus;
    }
}
