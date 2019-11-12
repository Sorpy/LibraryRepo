package business.processor.accountclientprocessor;

import business.converter.accountclient.*;
import data.entity.AccountClient;
import dataaccess.dao.accountclientdao.AccountClientDao;
import dataaccess.dao.accountclientdao.AccountClientDaoImpl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class AccountClientProcessorImpl implements AccountClientProcessor{
    private AccountClientDao accountClientDao = new AccountClientDaoImpl();
    private AccountClientParamConverter accountClientParamConverter = new AccountClientParamConverterImpl();
    private AccountClientResultConverter accountClientResultConverter = new AccountClientResultConverterImpl();


    @Override
    public AccountClientResult create(AccountClientParam param) throws IllegalAccessException {
        //try {
           // if (find(param.getId()).getId() == param.getId()) throw new ExistingIDException("Element with this ID already exists");
        //} catch (NoSuchElementException ignored){ }
        return accountClientResultConverter
                .convert(accountClientDao
                        .save(accountClientParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<AccountClientResult> create(List<AccountClientParam> param)  {
        List<AccountClient> accountClients = new ArrayList<>();
        List<AccountClientResult> accountClientsResult = new ArrayList<>();


        param.forEach
                (account -> accountClients
                        .add(accountClientParamConverter
                                .convert(account,null)));
        accountClientDao.save(accountClients);
        accountClients.forEach
                (clients -> {
                    try {
                        accountClientsResult
                                .add(accountClientResultConverter
                                        .convert(clients));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return accountClientsResult;
    }

    @Override
    public void update(Long id, AccountClientParam param) {
        AccountClient oldEntity = accountClientDao.find(id);
        if (oldEntity!=null){
            accountClientDao.update
                    (accountClientParamConverter.convert
                            (param,oldEntity));
        }else
            System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<AccountClientParam> param) {
        param.forEach(clientParam -> update(clientParam.getId(),clientParam));

    }

    @Override
    public void delete(Long id) {
        accountClientDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        accountClientDao.delete(idList);
    }

    @Override
    public AccountClientResult find(Long id) throws IllegalAccessException {
        return accountClientResultConverter
                .convert(accountClientDao.find(id));
    }

    @Override
    public List<AccountClientResult> find(){
        List<AccountClientResult> accountClientsResult = new ArrayList<>();
        accountClientDao.find()
                .forEach(accountClient -> {
                    try {
                        accountClientsResult
                                .add(accountClientResultConverter
                                        .convert(accountClient));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return accountClientsResult;
    }

    @Override
    public List<AccountClientResult> find(String firstName){
        List<AccountClientResult> accountClientResult = new ArrayList<>();
        accountClientDao
                .find(firstName.toLowerCase())
                .forEach(accountClient -> {
                    try {
                        accountClientResult
                                .add(accountClientResultConverter
                                        .convert(accountClient));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return accountClientResult;
    }

    @Override
    public List<AccountClientResult> find(String name, String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException {
        List<AccountClientResult> accountClientResult = new ArrayList<>();
        accountClientDao
                .find(name,value)
                .forEach(accountClient -> {
                    try {
                        accountClientResult
                                .add(accountClientResultConverter.convert(accountClient));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return accountClientResult;
    }
}
