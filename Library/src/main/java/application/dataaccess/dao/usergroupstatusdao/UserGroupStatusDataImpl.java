package application.dataaccess.dao.usergroupstatusdao;

import application.data.entity.UserGroupStatus;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class UserGroupStatusDataImpl extends BaseStorageImpl<Long, UserGroupStatus> implements UserGroupStatusData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\UserGroupStatusJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(UserGroupStatus userGroupStatus) {
        return userGroupStatus.getId();
    }
}
