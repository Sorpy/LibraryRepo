package application.dataaccess.dao.accountstatusdao;

import application.data.entity.AccountStatus;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class AccountStatusDataImpl extends BaseStorageImpl<Long, AccountStatus> implements AccountStatusData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\AccountStatusJSON");
    }

    @Override
    public Long getPK(AccountStatus accountStatus) {
        return accountStatus.getId();
    }


}
