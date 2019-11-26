package business.converter.genre;

import business.converter.common.BaseParamConverter;
import data.entity.Genre;

public interface GenreParamConverter extends BaseParamConverter<GenreParam,Genre> {
    Genre convert(GenreParam param, Genre oldEntity);
}
