package application.dataaccess.dao.accountdao;

import application.data.entity.Account;
import application.dataaccess.dao.common.BaseDao;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AccountDao extends BaseDao<Account, Long> {
}
