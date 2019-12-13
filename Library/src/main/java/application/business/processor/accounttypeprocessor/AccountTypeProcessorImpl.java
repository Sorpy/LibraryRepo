package application.business.processor.accounttypeprocessor;

import application.business.converter.accounttype.AccountTypeParam;
import application.business.converter.accounttype.AccountTypeParamConverter;
import application.business.converter.accounttype.AccountTypeResult;
import application.business.converter.accounttype.AccountTypeResultConverter;
import application.data.entity.AccountType;
import application.dataaccess.dao.accounttypedao.AccountTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AccountTypeProcessorImpl implements AccountTypeProcessor{
    @Autowired
    private AccountTypeDao accountTypeDao;
    @Autowired
    private AccountTypeParamConverter accountTypeParamConverter;
    @Autowired
    private AccountTypeResultConverter accountTypeResultConverter;


    @Override
    public AccountTypeResult create(AccountTypeParam param) {
        return accountTypeResultConverter
                .convert(accountTypeDao
                        .save(accountTypeParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<AccountTypeResult> create(List<AccountTypeParam> param) {
        List<AccountType> accountTypes = new ArrayList<>();
        List<AccountTypeResult> accountTypesResult = new ArrayList<>();

        param.forEach
                (accountType -> accountTypes
                        .add(accountTypeParamConverter
                                .convert(accountType,null)));
        accountTypeDao.save(accountTypes);
        accountTypes.forEach
                (type -> accountTypesResult
                        .add(accountTypeResultConverter
                                .convert(type)));

        return accountTypesResult;
    }

    @Override
    public void update(Long id, AccountTypeParam param) {
        AccountType oldEntity = accountTypeDao.find(id);
        if (oldEntity!=null){
            accountTypeDao
                    .update(accountTypeParamConverter
                            .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<AccountTypeParam> param) {
        List<AccountType> accountTypes = new ArrayList<>();
        param.forEach(account -> accountTypes
                .add(accountTypeParamConverter
                        .convert(account,null)));
        accountTypeDao.update(accountTypes);
    }

    @Override
    public void delete(Long id) {
        accountTypeDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        accountTypeDao.delete(idList);
    }

    @Override
    public AccountTypeResult find(Long id) {
        return accountTypeResultConverter
                .convert(accountTypeDao.find(id));
    }

    @Override
    public List<AccountTypeResult> find() {
        List<AccountTypeResult> accountTypeResult = new ArrayList<>();
        accountTypeDao.find()
                .forEach(accountType -> accountTypeResult
                        .add(accountTypeResultConverter
                                .convert(accountType)));
        return accountTypeResult;
    }
}

