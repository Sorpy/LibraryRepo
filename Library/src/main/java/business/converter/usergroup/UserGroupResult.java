package business.converter.usergroup;

import business.converter.BaseNamedResult;
import business.converter.BaseResult;
import data.entity.UserGroupStatus;

public class UserGroupResult extends BaseResult {

    private Long userGroupStatusId;
    private String userGroupStatusName;

    public Long getUserGroupStatusId() {
        return userGroupStatusId;
    }

    public void setUserGroupStatusId(Long userGroupStatusId) {
        this.userGroupStatusId = userGroupStatusId;
    }

    public String getUserGroupStatusName() {
        return userGroupStatusName;
    }

    public void setUserGroupStatusName(String userGroupStatusName) {
        this.userGroupStatusName = userGroupStatusName;
    }

}
