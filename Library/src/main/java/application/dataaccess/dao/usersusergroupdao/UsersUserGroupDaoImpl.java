package application.dataaccess.dao.usersusergroupdao;

import application.data.entity.UsersUserGroup;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static application.dataaccess.dao.usersusergroupdao.UsersUserGroupData.*;
@Component
public class UsersUserGroupDaoImpl implements UsersUserGroupDao {
    @Override
    public UsersUserGroup save(UsersUserGroup entity) {
        usersUserGroupMap.putIfAbsent(entity.getId(),entity);
        BaseStorage.saveToDataSource();
        return entity;
    }

    @Override
    public List<UsersUserGroup> save(List<UsersUserGroup> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public UsersUserGroup update(UsersUserGroup entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<UsersUserGroup> update(List<UsersUserGroup> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(long id) {
        UsersUserGroup removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(UsersUserGroup entity) {
    usersUserGroupMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<UsersUserGroup> find() {
        return new ArrayList<>(usersUserGroupMap.values());
    }

    @Override
    public UsersUserGroup find(long id) {
        return new ArrayList<>(usersUserGroupMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
