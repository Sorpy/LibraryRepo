package application.business.converter.author;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.Author;

public interface AuthorResultConverter extends BaseResultConverter<Author,AuthorResult> {
    AuthorResult convert(Author param);
}
