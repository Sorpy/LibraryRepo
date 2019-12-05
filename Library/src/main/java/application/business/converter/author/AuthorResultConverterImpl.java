package application.business.converter.author;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Author;
import org.springframework.stereotype.Component;

@Component
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
