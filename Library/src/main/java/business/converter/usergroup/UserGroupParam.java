package business.converter.usergroup;

import business.converter.BaseParam;
import data.entity.UserGroupStatus;

public class UserGroupParam extends BaseParam {
    private Long userGroupStatusId;

    public Long getUserGroupStatusId() {
        return userGroupStatusId;
    }

    public void setUserGroupStatusId(Long userGroupStatusId) {
        this.userGroupStatusId = userGroupStatusId;
    }
}
