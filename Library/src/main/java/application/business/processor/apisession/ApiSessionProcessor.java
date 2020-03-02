package application.business.processor.apisession;

import application.business.converter.apisession.ApiSessionParam;
import application.business.converter.apisession.ApiSessionResult;
import application.business.processor.common.BaseProcessor;

public interface ApiSessionProcessor extends BaseProcessor<ApiSessionParam, ApiSessionResult,Long> {

    ApiSessionResult getSession(String authToken);
}
