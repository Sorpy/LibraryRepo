package dataaccess.dao.userdao;

import data.entity.User;

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
        users.addAll(entity);
        return entity;
    }

    @Override
    public User update(User entity) {
        delete(entity.getId());
        users.add(entity);
        return entity;
    }

    @Override
    public List<User> update(List<User> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        User removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(User entity) {
        users.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<User> find() {
        return users;
    }

    @Override
    public User find(Long id) {
        return users
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
