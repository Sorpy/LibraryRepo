package business.processor.accountclientprocessor;

import business.converter.account.*;
import data.entity.Account;
import dataaccess.dao.accountdao.AccountDao;
import dataaccess.dao.accountdao.AccountDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
@Component
public class AccountProcessorImpl implements AccountProcessor {
    private AccountDao accountDao = new AccountDaoImpl();
    private AccountParamConverter accountParamConverter = new AccountParamConverterImpl();
    private AccountResultConverter accountResultConverter = new AccountResultConverterImpl();


    @Override
    public AccountResult create(AccountParam param) throws IllegalAccessException {
        //try {
           // if (find(param.getId()).getId() == param.getId()) throw new ExistingIDException("Element with this ID already exists");
        //} catch (NoSuchElementException ignored){ }
        return accountResultConverter
                .convert(accountDao
                        .save(accountParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<AccountResult> create(List<AccountParam> param)  {
        List<Account> accounts = new ArrayList<>();
        List<AccountResult> accountClientsResult = new ArrayList<>();


        param.forEach
                (account -> accounts
                        .add(accountParamConverter
                                .convert(account,null)));
        accountDao.save(accounts);
        accounts.forEach
                (clients -> {
                    try {
                        accountClientsResult
                                .add(accountResultConverter
                                        .convert(clients));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return accountClientsResult;
    }

    @Override
    public void update(Long id, AccountParam param) {
        Account oldEntity = accountDao.find(id);
        if (oldEntity!=null){
            accountDao.update
                    (accountParamConverter.convert
                            (param,oldEntity));
        }else
            System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<AccountParam> param) {
        List<Account> accounts = new ArrayList<>();
        param.forEach(account -> accounts
                .add(accountParamConverter
                        .convert(account,null)));
        accountDao.update(accounts);
    }

    @Override
    public void delete(Long id) {
        accountDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        accountDao.delete(idList);
    }

    @Override
    public AccountResult find(Long id) throws IllegalAccessException {
        return accountResultConverter
                .convert(accountDao.find(id));
    }

    @Override
    public List<AccountResult> find(){
        List<AccountResult> accountClientsResult = new ArrayList<>();
        accountDao.find()
                .forEach(accountClient -> {
                    try {
                        accountClientsResult
                                .add(accountResultConverter
                                        .convert(accountClient));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return accountClientsResult;
    }

    @Override
    public List<AccountResult> find(String firstName){
        List<AccountResult> accountClientResult = new ArrayList<>();
        accountDao
                .find(firstName.toLowerCase())
                .forEach(accountClient -> {
                    try {
                        accountClientResult
                                .add(accountResultConverter
                                        .convert(accountClient));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return accountClientResult;
    }

    @Override
    public List<AccountResult> find(String name, String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException {
        List<AccountResult> accountClientResult = new ArrayList<>();
        accountDao
                .find(name,value)
                .forEach(accountClient -> {
                    try {
                        accountClientResult
                                .add(accountResultConverter.convert(accountClient));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return accountClientResult;
    }
}
