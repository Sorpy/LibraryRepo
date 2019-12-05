package application.dataaccess.dao.accountstatusdao;

import application.data.entity.AccountStatus;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AccountStatusDaoImpl implements AccountStatusDao {
    @Override
    public AccountStatus save(AccountStatus entity) {
            AccountStatusData.accountStatusMap.putIfAbsent(entity.getId(),entity);
        //accountStatuses.add(entity);
        BaseStorage.saveToDataSource();

        return entity;
    }

    @Override
    public List<AccountStatus> save(List<AccountStatus> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public AccountStatus update(AccountStatus entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<AccountStatus> update(List<AccountStatus> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        AccountStatus removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(AccountStatus entity) {
        AccountStatusData.accountStatusMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<AccountStatus> find() {
        return new ArrayList<>(AccountStatusData.accountStatusMap.values());
    }

    @Override
    public AccountStatus find(Long id) {
        return new ArrayList<>(AccountStatusData.accountStatusMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
