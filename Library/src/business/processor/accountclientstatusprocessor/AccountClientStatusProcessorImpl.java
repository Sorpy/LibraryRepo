package business.processor.accountclientstatusprocessor;

import business.converter.accountclientstatus.*;
import data.entity.AccountStatus;
import dataaccess.dao.accountstatusdao.AccountStatusDao;
import dataaccess.dao.accountstatusdao.AccountStatusDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class AccountClientStatusProcessorImpl implements AccountClientStatusProcessor{
    private AccountStatusDao accountStatusDao = new AccountStatusDaoImpl();
    private AccountStatusParamConverter accountStatusParamConverter = new AccountStatusParamConverterImpl();
    private AccountStatusResultConverter accountStatusResultConverter = new AccountStatusResultConverterImpl();


    @Override
    public AccountStatusResult create(AccountStatusParam param) {
        return accountStatusResultConverter
                .convert(accountStatusDao
                        .save(accountStatusParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<AccountStatusResult> create(List<AccountStatusParam> param) {
        List<AccountStatus> accountClients = new ArrayList<>();
        List<AccountStatusResult> accountClientsResult = new ArrayList<>();

        param.forEach
                (accountClientStatus -> accountClients
                        .add(accountStatusParamConverter
                                .convert(accountClientStatus,null)));
        accountStatusDao.save(accountClients);
        accountClients.forEach
                (status -> accountClientsResult
                        .add(accountStatusResultConverter
                                .convert(status)));

        return accountClientsResult;
    }

    @Override
    public void update(Long id, AccountStatusParam param) {
        AccountStatus oldEntity = accountStatusDao.find(id);
        if (oldEntity!=null){
            accountStatusDao
                    .update(accountStatusParamConverter
                            .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<AccountStatusParam> param) {

    }

    @Override
    public void delete(Long id) {
        accountStatusDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        accountStatusDao.delete(idList);
    }

    @Override
    public AccountStatusResult find(Long id) {
        return accountStatusResultConverter
                .convert(accountStatusDao.find(id));
    }

    @Override
    public List<AccountStatusResult> find() {
        List<AccountStatusResult> accountStatusResult = new ArrayList<>();
        accountStatusDao.find()
                .forEach(accountClientStatus -> accountStatusResult
                        .add(accountStatusResultConverter
                                .convert(accountClientStatus)));
        return accountStatusResult;
    }
}
