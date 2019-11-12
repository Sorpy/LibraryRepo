package business.converter.usergroup;

import business.converter.BaseNamedResult;
import business.converter.BaseResult;
import data.entity.UserGroupStatus;

public class UserGroupResult extends BaseResult {
    private UserGroupStatus userGroupStatus;

    public UserGroupStatus getUserGroupStatus() {
        return userGroupStatus;
    }

    public void setUserGroupStatus(UserGroupStatus userGroupStatus) {
        this.userGroupStatus = userGroupStatus;
    }
}
