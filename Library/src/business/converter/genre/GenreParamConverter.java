package business.converter.genre;

import data.entity.Genre;

public interface GenreParamConverter {
    Genre convert(GenreParam param, Genre oldEntity);
}
