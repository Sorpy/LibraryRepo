package application.presentation.service.authorservice;

import application.business.converter.author.AuthorParam;
import application.data.common.APIResponse;

import java.util.List;

public interface AuthorService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(AuthorParam param);
    APIResponse create(List<AuthorParam> param);

    APIResponse update(long id, AuthorParam param);
    APIResponse update(List<AuthorParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(AuthorParam param);
    void validateParameters(List<AuthorParam> param);
}
