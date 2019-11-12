package business.processor.accountclientstatusprocessor;

import business.converter.accountclientstatus.*;
import data.entity.AccountClientStatus;
import dataaccess.dao.accountclientstatusdao.AccountClientStatusDao;
import dataaccess.dao.accountclientstatusdao.AccountClientStatusDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class AccountClientStatusProcessorImpl implements AccountClientStatusProcessor{
    private AccountClientStatusDao accountClientStatusDao = new AccountClientStatusDaoImpl();
    private AccountClientStatusParamConverter accountClientStatusParamConverter = new AccountClientStatusParamConverterImpl();
    private AccountClientStatusResultConverter accountClientStatusResultConverter = new AccountClientStatusResultConverterImpl();


    @Override
    public AccountClientStatusResult create(AccountClientStatusParam param) {
        return accountClientStatusResultConverter
                .convert(accountClientStatusDao
                        .save(accountClientStatusParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<AccountClientStatusResult> create(List<AccountClientStatusParam> param) {
        List<AccountClientStatus> accountClients = new ArrayList<>();
        List<AccountClientStatusResult> accountClientsResult = new ArrayList<>();

        param.forEach
                (accountClientStatus -> accountClients
                        .add(accountClientStatusParamConverter
                                .convert(accountClientStatus,null)));
        accountClientStatusDao.save(accountClients);
        accountClients.forEach
                (status -> accountClientsResult
                        .add(accountClientStatusResultConverter
                                .convert(status)));

        return accountClientsResult;
    }

    @Override
    public void update(Long id, AccountClientStatusParam param) {
        AccountClientStatus oldEntity = accountClientStatusDao.find(id);
        if (oldEntity!=null){
            accountClientStatusDao
                    .update(accountClientStatusParamConverter
                            .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<AccountClientStatusParam> param) {

    }

    @Override
    public void delete(Long id) {
        accountClientStatusDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        accountClientStatusDao.delete(idList);
    }

    @Override
    public AccountClientStatusResult find(Long id) {
        return accountClientStatusResultConverter
                .convert(accountClientStatusDao.find(id));
    }

    @Override
    public List<AccountClientStatusResult> find() {
        List<AccountClientStatusResult> accountClientStatusResult = new ArrayList<>();
        accountClientStatusDao.find()
                .forEach(accountClientStatus -> accountClientStatusResult
                        .add(accountClientStatusResultConverter
                                .convert(accountClientStatus)));
        return accountClientStatusResult;
    }
}
