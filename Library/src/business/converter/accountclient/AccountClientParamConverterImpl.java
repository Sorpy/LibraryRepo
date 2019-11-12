package business.converter.accountclient;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.AccountClient;
import dataaccess.dao.accountclientstatusdao.AccountClientStatusDao;
import dataaccess.dao.accountclientstatusdao.AccountClientStatusDaoImpl;
import dataaccess.dao.userdao.UserDao;
import dataaccess.dao.userdao.UserDaoImpl;

public class AccountClientParamConverterImpl extends BaseParamConverterImpl<AccountClientParam,AccountClient> implements AccountClientParamConverter{
    private UserDao userDao = new UserDaoImpl();
    private AccountClientStatusDao accountClientStatusDao = new AccountClientStatusDaoImpl();



    @Override
    public AccountClient convert(AccountClientParam param, AccountClient oldEntity){
        AccountClient entity = null;
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
            entity = new AccountClient();
            entity.setId(param.getId());
            entity.setCode(param.getCode());
        }
        entity = convertStandart(param,entity);
        entity = convertSpecific(param,entity);
        return entity;
    }


    @Override
    public AccountClient convertSpecific(AccountClientParam param, AccountClient entity) {
        entity.setUser(userDao.find(param.getUserId()));
        entity.setAccountClientStatus(accountClientStatusDao.find(param.getAccountClientStatusId()));
        return entity;
    }
}
