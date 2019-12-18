package application.business.converter.genre;

import application.data.entity.Genre;
import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import org.springframework.stereotype.Component;

@Component
public class GenreParamConverterImpl
        extends BaseParamConverterImpl<GenreParam, Genre>
        implements GenreParamConverter {



    @Override
    public void convertSpecific(GenreParam param, Genre entity) {
    }

    @Override
    public Genre getEntity(GenreParam param) {
        Genre genre = new Genre();
        genre.setCode(param.getCode());
        genre.setId(param.getId());
        return genre;
    }
}