package application.business.converter.apisession;

import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.ApiSession;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionParamConverterImpl  extends BaseParamConverterImpl<ApiSessionParam, ApiSession> implements ApiSessionParamConverter{
    @Override
    public void convertSpecific(ApiSessionParam param, ApiSession entity) {

    }

    @Override
    public ApiSession getEntity(ApiSessionParam param) {
        ApiSession apiSession = new ApiSession();
        apiSession.setId(param.getId());
        apiSession.setCode(param.getCode());
        return apiSession;
    }
}
