package application.dataaccess.dao.userstatusdao;

import application.data.entity.UserStatus;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class UserStatusDataImpl extends BaseStorageImpl<Long, UserStatus> implements UserStatusData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\UserStatusJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(UserStatus userStatus) {
        return userStatus.getId();
    }
}
