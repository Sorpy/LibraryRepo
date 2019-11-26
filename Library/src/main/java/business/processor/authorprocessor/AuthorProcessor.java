package business.processor.authorprocessor;

import business.converter.author.AuthorParam;
import business.converter.author.AuthorResult;

import java.util.List;

public interface AuthorProcessor {
    AuthorResult create(AuthorParam param);
    List<AuthorResult> create(List<AuthorParam> param);

    void update(Long id,AuthorParam param);
    void update(List<AuthorParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    AuthorResult find(Long id);
    List<AuthorResult> find();
}
