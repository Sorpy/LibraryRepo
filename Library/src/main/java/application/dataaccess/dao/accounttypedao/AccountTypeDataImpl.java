package application.dataaccess.dao.accounttypedao;

import application.data.entity.AccountType;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class AccountTypeDataImpl extends BaseStorageImpl<Long, AccountType> implements AccountTypeData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\AccountTypeJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(AccountType accountType) {
        return accountType.getId();
    }
}
