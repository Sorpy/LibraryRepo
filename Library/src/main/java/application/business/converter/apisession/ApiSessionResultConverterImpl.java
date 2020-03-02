package application.business.converter.apisession;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.ApiSession;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionResultConverterImpl  extends BaseResultConverterImpl<ApiSession, ApiSessionResult> implements ApiSessionResultConverter{
    @Override
    public void convertSpecific(ApiSession entity, ApiSessionResult result) {

    }

    @Override
    public ApiSessionResult getResult() {
        return new ApiSessionResult();
    }
}
