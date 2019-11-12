package business.converter.author;

import business.converter.common.BaseParamConverter;
import data.entity.Author;

public interface AuthorParamConverter extends BaseParamConverter<AuthorParam,Author> {

    Author convert(AuthorParam param, Author oldEntity);
}
