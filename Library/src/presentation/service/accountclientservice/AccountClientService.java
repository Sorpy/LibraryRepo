package presentation.service.accountclientservice;

import business.converter.accountclient.AccountClientParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import data.common.APIResponse;

import java.util.List;

public interface AccountClientService {

    APIResponse findByPK(Long id);
    APIResponse listAll() throws JsonProcessingException;
    APIResponse findByName(String name);
    APIResponse findByParameter(String name,String value);

    APIResponse create(AccountClientParam param) throws JsonProcessingException;
    APIResponse create(List<AccountClientParam> param) throws JsonProcessingException;

    APIResponse update(Long id, AccountClientParam param);
    APIResponse update(List<AccountClientParam> param);

    APIResponse deleteById(Long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(AccountClientParam param);
    void validateParameters(List<AccountClientParam> param);
}
