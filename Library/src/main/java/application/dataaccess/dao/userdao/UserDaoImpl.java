package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao{
    @Override
    public User save(User entity) {
        UserData.userMap.putIfAbsent(entity.getId(), entity);
        UserData.users.add(entity);
        BaseStorage.saveToDataSource();
        return entity;
    }

    @Override
    public List<User> save (List<User> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public User update(User entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<User> update(List<User> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        User removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(User entity) {
        UserData.userMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<User> find() {
        return new ArrayList<>(UserData.userMap.values());
    }

    @Override
    public User find(Long id) {
        return new ArrayList<>(UserData.userMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
