package application.business.converter.genre;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreResultConverterImpl
        extends BaseResultConverterImpl<Genre,GenreResult>
        implements GenreResultConverter{

    @Override
    public void convertSpecific(Genre entity, GenreResult result) {
    }

    @Override
    public GenreResult getResult() {
        return new GenreResult();
    }
}
