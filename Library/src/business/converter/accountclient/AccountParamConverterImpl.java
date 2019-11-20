package business.converter.accountclient;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.Account;
import dataaccess.dao.accountstatusdao.AccountStatusDao;
import dataaccess.dao.accountstatusdao.AccountStatusDaoImpl;
import dataaccess.dao.userdao.UserDao;
import dataaccess.dao.userdao.UserDaoImpl;

public class AccountParamConverterImpl extends BaseParamConverterImpl<AccountParam,Account> implements AccountParamConverter {
    private UserDao userDao = new UserDaoImpl();
    private AccountStatusDao accountStatusDao = new AccountStatusDaoImpl();



    @Override
    public Account convert(AccountParam param, Account oldEntity){
        Account entity = null;
        if(oldEntity!=null)
        {
            if(param.getId().equals(oldEntity.getId())&& param.getUnicode().equals(oldEntity.getCode())){
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
            entity = new Account();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param,entity);
        entity = convertSpecific(param,entity);
        return entity;
    }


    @Override
    public Account convertSpecific(AccountParam param, Account entity) {
        entity.setUser(userDao.find(param.getUserId()));
        entity.setAccountStatus(accountStatusDao.find(param.getAccountClientStatusId()));
        return entity;
    }
}
