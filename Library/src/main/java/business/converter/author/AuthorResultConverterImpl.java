package business.converter.author;

import business.converter.common.BaseResultConverterImpl;
import data.entity.Author;

public class AuthorResultConverterImpl extends BaseResultConverterImpl<Author,AuthorResult> implements AuthorResultConverter{
    @Override
    public AuthorResult convert(Author param) {
        AuthorResult authorResult = new AuthorResult();
        authorResult =convertStandart(param,authorResult);
        return authorResult;
    }

    @Override
    public AuthorResult convertSpecific(Author entity, AuthorResult result) {
        return null;
    }
}
