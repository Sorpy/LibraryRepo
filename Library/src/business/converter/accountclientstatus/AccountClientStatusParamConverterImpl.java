package business.converter.accountclientstatus;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.AccountClientStatus;

public class AccountClientStatusParamConverterImpl extends BaseParamConverterImpl<AccountClientStatusParam,AccountClientStatus> implements AccountClientStatusParamConverter {


    @Override
    public AccountClientStatus convert(AccountClientStatusParam param, AccountClientStatus oldEntity){
        AccountClientStatus entity = null;
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
            entity = new AccountClientStatus();
            entity.setId(param.getId());
            entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param,entity);
        return entity;
    }

    @Override
    public AccountClientStatus convertSpecific(AccountClientStatusParam param, AccountClientStatus entity) {
        return null;
    }
}
