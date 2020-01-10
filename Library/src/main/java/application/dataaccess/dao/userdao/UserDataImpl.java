package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class UserDataImpl extends BaseStorageImpl<Long, User> implements UserData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\UserJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(User user) {
        return user.getId();
    }
}
