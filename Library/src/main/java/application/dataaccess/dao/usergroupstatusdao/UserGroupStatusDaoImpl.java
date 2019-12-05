package application.dataaccess.dao.usergroupstatusdao;

import application.data.entity.UserGroupStatus;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import static application.dataaccess.dao.usergroupstatusdao.UserGroupStatusData.*;
@Component
public class UserGroupStatusDaoImpl implements UserGroupStatusDao{
    @Override
    public UserGroupStatus save(UserGroupStatus entity) {
        userGroupStatusMap.putIfAbsent(entity.getId(),entity);
        BaseStorage.saveToDataSource();
        return entity;
    }

    @Override
    public List<UserGroupStatus> save(List<UserGroupStatus> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public UserGroupStatus update(UserGroupStatus entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<UserGroupStatus> update(List<UserGroupStatus> entity) {
        return null;
    }

    @Override
    public void delete(long id) {
        UserGroupStatus removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(UserGroupStatus entity) {
        userGroupStatusMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<UserGroupStatus> find() {
        return new ArrayList<>(userGroupStatusMap.values());
    }

    @Override
    public UserGroupStatus find(long id) {
        return new ArrayList<>(userGroupStatusMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
