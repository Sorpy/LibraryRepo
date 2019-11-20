package business.converter.genre;

import business.converter.common.BaseResultConverterImpl;
import data.entity.Genre;

public class GenreResultConverterImpl extends BaseResultConverterImpl<Genre,GenreResult> implements GenreResultConverter{
    @Override
    public GenreResult convert(Genre param) {
        GenreResult bookStatusResult = new GenreResult();
        bookStatusResult = convertStandart(param,bookStatusResult);
        return bookStatusResult;
    }

    @Override
    public GenreResult convertSpecific(Genre entity, GenreResult result) {
        return null;
    }
}
