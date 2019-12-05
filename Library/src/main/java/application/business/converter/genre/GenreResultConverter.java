package application.business.converter.genre;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.Genre;

public interface GenreResultConverter extends BaseResultConverter<Genre,GenreResult> {
    GenreResult convert(Genre param);
}
