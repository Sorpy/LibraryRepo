package business.converter.genre;

import business.converter.common.BaseResultConverter;
import data.entity.Genre;

public interface GenreResultConverter extends BaseResultConverter<Genre,GenreResult> {
    GenreResult convert(Genre param);
}
