package presentation.service.accountservice;

import business.converter.accountclient.AccountParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import data.common.APIResponse;

import java.util.List;

public interface AccountService {

    APIResponse findByPK(Long id);
    APIResponse listAll() throws JsonProcessingException;
    APIResponse findByName(String name);
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
