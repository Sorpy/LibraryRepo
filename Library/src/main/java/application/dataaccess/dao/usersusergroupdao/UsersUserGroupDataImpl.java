package application.dataaccess.dao.usersusergroupdao;

import application.data.entity.UsersUserGroup;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class UsersUserGroupDataImpl extends BaseStorageImpl<Long, UsersUserGroup> implements UsersUserGroupData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\UsersUserGroupJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(UsersUserGroup usersUserGroup) {
        return usersUserGroup.getId();
    }
}
