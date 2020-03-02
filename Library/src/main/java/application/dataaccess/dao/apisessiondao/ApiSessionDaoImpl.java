package application.dataaccess.dao.apisessiondao;

import application.data.entity.ApiSession;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

import javax.transaction.Transactional;
import java.util.List;

public class ApiSessionDaoImpl extends BaseDaoJPAImpl<ApiSession,Long> implements ApiSessionDao {

    @Override
    public Class<ApiSession> getMyType() {
        return ApiSession.class;
    }

    @Transactional
    @Override
    public ApiSession getSession(String authToken) {
        List<ApiSession> apiSessions  = find("authToken",authToken);
        return apiSessions.get(0);
    }

    @Transactional
    @Override
    public ApiSession getSessionByUsername(String username) {
        List<ApiSession> session  = find("name",username);
        return session.get(0);
    }
}
