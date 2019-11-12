package business.processor.accountlibrarianstatusprocessor;

import business.converter.accountlibrarianstatus.*;
import data.entity.AccountLibrarianStatus;
import dataaccess.dao.accountlibrarianstatusdao.AccountLibrarianStatusDao;
import dataaccess.dao.accountlibrarianstatusdao.AccountLibrarianStatusDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class AccountLibrarianStatusProcessorImpl implements AccountLibrarianStatusProcessor{
    private AccountLibrarianStatusDao accountLibrarianStatusDao = new AccountLibrarianStatusDaoImpl();
    private AccountLibrarianStatusParamConverter accountLibrarianStatusParamConverter = new AccountLibrarianStatusParamConverterImpl();
    private AccountLibrarianStatusResultConverter accountLibrarianStatusResultConverter = new AccountLibrarianStatusResultConverterImpl();

    @Override
    public AccountLibrarianStatusResult create(AccountLibrarianStatusParam param) {
        return accountLibrarianStatusResultConverter
                .convert(accountLibrarianStatusDao
                        .save(accountLibrarianStatusParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<AccountLibrarianStatusResult> create(List<AccountLibrarianStatusParam> param) {
        List<AccountLibrarianStatus> accountLibrarianStatuses = new ArrayList<>();
        List<AccountLibrarianStatusResult> accountClientsResult = new ArrayList<>();

        param.forEach
                (account -> accountLibrarianStatuses
                        .add(accountLibrarianStatusParamConverter.convert(account,null)));
        accountLibrarianStatusDao.save(accountLibrarianStatuses);
        accountLibrarianStatuses.forEach
                (librarianStatus -> accountClientsResult
                        .add(accountLibrarianStatusResultConverter.convert(librarianStatus)));

        return accountClientsResult;
    }

    @Override
    public void update(Long id, AccountLibrarianStatusParam param) {
        AccountLibrarianStatus oldEntity = accountLibrarianStatusDao.find(id);
        if (oldEntity!=null){
            accountLibrarianStatusDao.update
                    (accountLibrarianStatusParamConverter.convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<AccountLibrarianStatusParam> param) {

    }

    @Override
    public void delete(Long id) {
        accountLibrarianStatusDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        accountLibrarianStatusDao.delete(idList);
    }

    @Override
    public AccountLibrarianStatusResult find(Long id) {
        return accountLibrarianStatusResultConverter
                .convert(accountLibrarianStatusDao.find(id));
    }

    @Override
    public List<AccountLibrarianStatusResult> find() {
        List<AccountLibrarianStatusResult> accountLibrarianStatusResult = new ArrayList<>();
        accountLibrarianStatusDao.find()
                .forEach(accountLibrarianStatus -> accountLibrarianStatusResult
                        .add(accountLibrarianStatusResultConverter
                                .convert(accountLibrarianStatus)));
        return accountLibrarianStatusResult;
    }
}
