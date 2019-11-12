package business.processor.accountlibrarianprocessor;

import business.converter.accountlibrarian.*;
import data.entity.AccountLibrarian;
import dataaccess.dao.accountlibrariandao.AccountLibrarianDao;
import dataaccess.dao.accountlibrariandao.AccountLibrarianDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class AccountLibrarianProcessorImpl implements AccountLibrarianProcessor{
    private AccountLibrarianDao accountLibrarianDao = new AccountLibrarianDaoImpl();
    private AccountLibrarianParamConverter accountLibrarianParamConverter = new AccountLibrarianParamConverterImpl();
    private AccountLibrarianResultConverter accountLibrarianResultConverter = new AccountLibrarianResultConverterImpl();


    @Override
    public AccountLibrarianResult create(AccountLibrarianParam param) {
        return accountLibrarianResultConverter
                .convert(accountLibrarianDao
                        .save(accountLibrarianParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<AccountLibrarianResult> create(List<AccountLibrarianParam> param) {
        List<AccountLibrarian> accountLibrarians = new ArrayList<>();
        List<AccountLibrarianResult> accountLibrarianResult = new ArrayList<>();

        param.forEach
                (account -> accountLibrarians
                        .add(accountLibrarianParamConverter
                                .convert(account,null)));
        accountLibrarianDao.save(accountLibrarians);
        accountLibrarians.forEach
                (librarian -> accountLibrarianResult
                        .add(accountLibrarianResultConverter
                                .convert(librarian)));

        return accountLibrarianResult;
    }

    @Override
    public void update(Long id, AccountLibrarianParam param) {
        AccountLibrarian oldEntity = accountLibrarianDao.find(id);
        if (oldEntity!=null){
            accountLibrarianDao
                    .update(accountLibrarianParamConverter
                            .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<AccountLibrarianParam> param) {

    }

    @Override
    public void delete(Long id) {
        accountLibrarianDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        accountLibrarianDao.delete(idList);
    }

    @Override
    public AccountLibrarianResult find(Long id) {
        return accountLibrarianResultConverter
                .convert(accountLibrarianDao.find(id));
    }

    @Override
    public List<AccountLibrarianResult> find() {
        List<AccountLibrarianResult> accountLibrariansResult = new ArrayList<>();
        accountLibrarianDao.find()
                .forEach(accountLibrarian -> accountLibrariansResult
                        .add(accountLibrarianResultConverter
                                .convert(accountLibrarian)));
        return accountLibrariansResult;
    }
    public List<AccountLibrarianResult> find(String firstName){
        List<AccountLibrarianResult> accountLibrariansResult = new ArrayList<>();
        accountLibrarianDao
                .find(firstName.toLowerCase())
                .forEach(accountLibrarian -> accountLibrariansResult
                        .add(accountLibrarianResultConverter.convert(accountLibrarian)));
        return accountLibrariansResult;
    }
}
