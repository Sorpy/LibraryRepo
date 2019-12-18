package application.business.converter.author;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorResultConverterImpl extends BaseResultConverterImpl<Author,AuthorResult> implements AuthorResultConverter{
    @Override
    public AuthorResult getResult() {
        return new AuthorResult();
    }

    @Override
    public void convertSpecific(Author entity, AuthorResult result) { }
}
