package dataaccess.dao.userstatusdao;

import data.entity.UserStatus;

import java.util.ArrayList;
import java.util.List;

import static dataaccess.dao.userstatusdao.UserStatusData.*;

public class UserStatusDaoImpl implements UserStatusDao{
    @Override
    public UserStatus save(UserStatus entity) {
        userStatusMap.putIfAbsent(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<UserStatus> save(List<UserStatus> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public UserStatus update(UserStatus entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<UserStatus> update(List<UserStatus> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(long id) {
        UserStatus removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(UserStatus entity) {
        userStatusMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<UserStatus> find() {
        return new ArrayList<>(userStatusMap.values());
    }

    @Override
    public UserStatus find(long id) {
        return new ArrayList<>(userStatusMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
