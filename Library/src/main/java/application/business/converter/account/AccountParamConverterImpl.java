package application.business.converter.account;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.Account;
import application.dataaccess.dao.accountstatusdao.AccountStatusDao;
import application.dataaccess.dao.accountstatusdao.AccountStatusDaoImpl;
import application.dataaccess.dao.userdao.UserDao;
import application.dataaccess.dao.userdao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountParamConverterImpl extends BaseParamConverterImpl<AccountParam,Account> implements AccountParamConverter {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AccountStatusDao accountStatusDao;



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
