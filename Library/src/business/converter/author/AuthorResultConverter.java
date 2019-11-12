package business.converter.author;

import business.converter.common.BaseResultConverter;
import data.entity.Author;

public interface AuthorResultConverter extends BaseResultConverter<Author,AuthorResult> {
    AuthorResult convert(Author param);
}
