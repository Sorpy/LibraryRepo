package application.dataaccess.dao.usergroupdao;

import application.data.entity.UserGroup;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class UserGroupDataImpl extends BaseStorageImpl<Long, UserGroup> implements UserGroupData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\UserGroupJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(UserGroup userGroup) {
        return userGroup.getId();
    }
}
