package business.converter.genre;

import data.entity.Genre;

public class GenreResultConverterImpl implements GenreResultConverter{
    @Override
    public GenreResult convert(Genre param) {
        GenreResult genreResult = new GenreResult();
        genreResult.setCode(param.getCode());
        genreResult.setName(param.getName());
        genreResult.setDescription(param.getDescription());
        genreResult.setId(param.getId());
        return genreResult;
    }
}
