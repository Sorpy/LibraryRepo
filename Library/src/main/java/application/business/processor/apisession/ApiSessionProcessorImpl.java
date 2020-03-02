package application.business.processor.apisession;

import application.business.converter.apisession.ApiSessionParam;
import application.business.converter.apisession.ApiSessionParamConverter;
import application.business.converter.apisession.ApiSessionResult;
import application.business.converter.apisession.ApiSessionResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.ApiSession;
import application.dataaccess.dao.apisessiondao.ApiSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionProcessorImpl  extends BaseProcessorImpl<ApiSessionParam, ApiSession, ApiSessionResult,Long,
        ApiSessionDao, ApiSessionParamConverter, ApiSessionResultConverter>
        implements ApiSessionProcessor{

    @Autowired
    private ApiSessionDao apiSessionDao;

    @Autowired
    private ApiSessionResultConverter apiSessionResultConverter;

    @Override
    public Long getPK(ApiSessionParam ent) {
        return ent.getId();
    }

    @Override
    public ApiSessionResult getSession(String authToken) {
        return apiSessionResultConverter.convert(apiSessionDao.getSession(authToken));
    }
}
