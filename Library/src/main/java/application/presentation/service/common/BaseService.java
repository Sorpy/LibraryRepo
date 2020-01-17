package application.presentation.service.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseService<IN,PK> {

    ResponseEntity findByPK(PK id);
    ResponseEntity listAll() throws JsonProcessingException;
    ResponseEntity findByParameter(String name,String value);

    ResponseEntity create(IN param) throws JsonProcessingException;
    ResponseEntity create(List<IN> param) throws JsonProcessingException;

    ResponseEntity update(PK id, IN param);
    ResponseEntity update(List<IN> param);

    ResponseEntity deleteById(PK id);
    ResponseEntity delete(List<PK> idList);

    void validateParameters(IN param);
    void validateParameters(List<IN> param);
}
