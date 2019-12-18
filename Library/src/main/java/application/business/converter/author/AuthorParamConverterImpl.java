package application.business.converter.author;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorParamConverterImpl extends BaseParamConverterImpl<AuthorParam,Author> implements AuthorParamConverter {

    @Override
    public void convertSpecific(AuthorParam param, Author entity) {
    }

    @Override
    public Author getEntity(AuthorParam param) {
        Author author = new Author();
        author.setId(param.getId());
        author.setCode(param.getCode());
        return author;
    }
}
