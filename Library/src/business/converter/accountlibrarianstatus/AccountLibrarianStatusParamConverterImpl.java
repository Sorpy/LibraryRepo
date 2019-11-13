package business.converter.accountlibrarianstatus;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.AccountLibrarianStatus;

public class AccountLibrarianStatusParamConverterImpl extends BaseParamConverterImpl<AccountLibrarianStatusParam,AccountLibrarianStatus> implements AccountLibrarianStatusParamConverter{

    @Override
    public AccountLibrarianStatus convert(AccountLibrarianStatusParam param, AccountLibrarianStatus oldEntity){
        AccountLibrarianStatus entity = null;
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
            entity = new AccountLibrarianStatus();
            entity.setId(param.getId());
            entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param,entity);
        return entity;
    }

    @Override
    public AccountLibrarianStatus convertSpecific(AccountLibrarianStatusParam param, AccountLibrarianStatus entity) {
        return null;
    }
}
