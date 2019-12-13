package application.business.converter.accounttype;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeParamConverterImpl extends BaseParamConverterImpl<AccountTypeParam,AccountType>implements AccountTypeParamConverter {
    @Override
    public AccountType convert(AccountTypeParam param, AccountType oldEntity){
        AccountType entity = null;
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
            entity = new AccountType();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param,entity);
        return entity;
    }

    @Override
    public AccountType convertSpecific(AccountTypeParam param, AccountType entity) {
        return null;
    }
}