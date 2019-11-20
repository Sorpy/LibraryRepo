package dataaccess.dao.userdao;

import data.entity.User;

import java.util.ArrayList;
import java.util.List;

import static dataaccess.dao.userdao.UserData.*;

public class UserDaoImpl implements UserDao{
    @Override
    public User save(User entity) {
        userMap.putIfAbsent(entity.getId(), entity);
        users.add(entity);

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
    }

    @Override
    public void delete(User entity) {
        userMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<User> find() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User find(Long id) {
        return new ArrayList<>(userMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
