package application.dataaccess.dao.usergroupdao;

import application.data.entity.UserGroup;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static application.dataaccess.dao.usergroupdao.UserGroupData.*;
@Component
public class UserGroupDaoImpl implements UserGroupDao{
    @Override
    public UserGroup save(UserGroup entity) {
        userGroupMap.putIfAbsent(entity.getId(), entity);
        userGroups.add(entity);
        BaseStorage.saveToDataSource();
        return entity;
    }

    @Override
    public List<UserGroup> save (List<UserGroup> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public UserGroup update(UserGroup entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<UserGroup> update(List<UserGroup> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(long id) {
        UserGroup removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(UserGroup entity) {
        userGroupMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<UserGroup> find() {
        return new ArrayList<>(userGroupMap.values());
    }

    @Override
    public UserGroup find(long id) {
        return new ArrayList<>(userGroupMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
