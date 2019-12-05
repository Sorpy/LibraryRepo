package application.business.converter.usergroup;

import application.business.converter.BaseResult;
import org.springframework.stereotype.Component;

@Component
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
