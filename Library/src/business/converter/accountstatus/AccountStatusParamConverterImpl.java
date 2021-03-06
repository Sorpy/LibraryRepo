package business.converter.accountstatus;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.AccountStatus;

public class AccountStatusParamConverterImpl extends BaseParamConverterImpl<AccountStatusParam,AccountStatus> implements AccountStatusParamConverter {


    @Override
    public AccountStatus convert(AccountStatusParam param, AccountStatus oldEntity){
        AccountStatus entity = null;
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
            entity = new AccountStatus();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param,entity);
        return entity;
    }

    @Override
    public AccountStatus convertSpecific(AccountStatusParam param, AccountStatus entity) {
        return null;
    }
}
