package application.presentation.service.common;

import application.data.common.APIResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface BaseService<IN,PK> {

    APIResponse findByPK(PK id);
    APIResponse listAll() throws JsonProcessingException;
    APIResponse findByParameter(String name,String value);

    APIResponse create(IN param) throws JsonProcessingException;
    APIResponse create(List<IN> param) throws JsonProcessingException;

    APIResponse update(PK id, IN param);
    APIResponse update(List<IN> param);

    APIResponse deleteById(PK id);
    APIResponse delete(List<PK> idList);

    void validateParameters(IN param);
    void validateParameters(List<IN> param);
}
