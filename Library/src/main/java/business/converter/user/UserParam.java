package business.converter.user;

import business.converter.BaseParam;
import data.entity.UserStatus;

public class UserParam extends BaseParam {
    private String username;
    private String password;
    private Long userStatusId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(Long userStatusId) {
        this.userStatusId = userStatusId;
    }
}
