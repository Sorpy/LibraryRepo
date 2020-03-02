package application.dataaccess.dao.apisessiondao;

import application.data.entity.ApiSession;
import application.dataaccess.dao.common.commondao.BaseDao;

public interface ApiSessionDao extends BaseDao<ApiSession,Long> {

    ApiSession getSession(String authToken);
    ApiSession getSessionByUsername(String username);
}
