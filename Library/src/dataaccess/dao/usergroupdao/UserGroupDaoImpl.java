package dataaccess.dao.usergroupdao;

import data.entity.UserGroup;

import java.util.List;

import static dataaccess.dao.usergroupdao.UserGroupData.*;

public class UserGroupDaoImpl implements UserGroupDao{
    @Override
    public UserGroup save(UserGroup entity) {
        userGroupMap.putIfAbsent(entity.getId(), entity);
        userGroups.add(entity);

        return entity;
    }

    @Override
    public List<UserGroup> save (List<UserGroup> entity) {
        userGroups.addAll(entity);
        return entity;
    }

    @Override
    public UserGroup update(UserGroup entity) {
        userGroups.add(entity);
        return entity;
    }

    @Override
    public List<UserGroup> update(List<UserGroup> entity) {
        return null;
    }

    @Override
    public void delete(long id) {
        UserGroup removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(UserGroup entity) {
        userGroups.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<UserGroup> find() {
        return userGroups;
    }

    @Override
    public UserGroup find(long id) {
        return userGroups
                .stream()
                .filter(a -> a.getId()==id)
                .findFirst().get();
    }
}
