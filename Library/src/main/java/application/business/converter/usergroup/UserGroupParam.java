package application.business.converter.usergroup;

import application.business.converter.BaseParam;
import org.springframework.stereotype.Component;

@Component
public class UserGroupParam extends BaseParam {
    private Long userGroupStatusId;

    public Long getUserGroupStatusId() {
        return userGroupStatusId;
    }

    public void setUserGroupStatusId(Long userGroupStatusId) {
        this.userGroupStatusId = userGroupStatusId;
    }
}
