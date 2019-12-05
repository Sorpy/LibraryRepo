package application.business.converter.genre;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreResultConverterImpl extends BaseResultConverterImpl<Genre,GenreResult> implements GenreResultConverter{
    @Override
    public GenreResult convert(Genre param) {
        GenreResult genreResult = new GenreResult();
        genreResult = convertStandart(param,genreResult);
        return genreResult;
    }

    @Override
    public GenreResult convertSpecific(Genre entity, GenreResult result) {
        return null;
    }
}
