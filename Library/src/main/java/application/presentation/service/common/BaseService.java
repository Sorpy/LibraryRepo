package application.presentation.service.common;

import application.data.common.APIResponse;

public interface BaseService<IN,ENT,OUT,PK> {

    APIResponse findByPK(Long id);
    APIResponse listAll() throws JsonProcessingException;
    APIResponse findByParameter(String name,String value);

    APIResponse create(AccountParam param) throws JsonProcessingException;
    APIResponse create(List<AccountParam> param) throws JsonProcessingException;

    APIResponse update(Long id, AccountParam param);
    APIResponse update(List<AccountParam> param);

    APIResponse deleteById(Long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(AccountParam param);
    void validateParameters(List<AccountParam> param);
}
}
