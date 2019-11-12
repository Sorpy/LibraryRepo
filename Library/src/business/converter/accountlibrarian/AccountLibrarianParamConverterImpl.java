package business.converter.accountlibrarian;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.AccountLibrarian;
import dataaccess.dao.accountlibrarianstatusdao.AccountLibrarianStatusDao;
import dataaccess.dao.accountlibrarianstatusdao.AccountLibrarianStatusDaoImpl;
import dataaccess.dao.userdao.UserDao;
import dataaccess.dao.userdao.UserDaoImpl;

public class AccountLibrarianParamConverterImpl extends BaseParamConverterImpl<AccountLibrarianParam,AccountLibrarian> implements AccountLibrarianParamConverter{
    private UserDao userDao = new UserDaoImpl();
    private AccountLibrarianStatusDao accountLibrarianStatusDao = new AccountLibrarianStatusDaoImpl();


    @Override
    public AccountLibrarian convert(AccountLibrarianParam param, AccountLibrarian oldEntity){
        AccountLibrarian entity = null;
        if(oldEntity!=null)
        {
            if(param.getId().equals(oldEntity.getId())&& param.getCode().equals(oldEntity.getCode())){
                entity = oldEntity;
            }
            else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            entity = new AccountLibrarian();
            entity.setId(param.getId());
            entity.setCode(param.getCode());
        }
        entity = convertStandart(param,entity);
        entity = convertSpecific(param,entity);
        return entity;
    }


    @Override
    public AccountLibrarian convertSpecific(AccountLibrarianParam param, AccountLibrarian entity) {
        entity.setUser(userDao.find(param.getUserId()));
        entity.setAccountLibrarianStatus(accountLibrarianStatusDao.find(param.getAccountLibrarianStatusId()));
        return entity;
    }
}
