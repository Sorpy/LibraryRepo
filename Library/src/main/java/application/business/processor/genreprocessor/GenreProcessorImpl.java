package application.business.processor.genreprocessor;


import application.business.converter.genre.GenreParam;
import application.business.converter.genre.GenreParamConverter;
import application.business.converter.genre.GenreResult;
import application.business.converter.genre.GenreResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Genre;
import application.dataaccess.dao.genredao.GenreDao;
import org.springframework.stereotype.Component;
@Component
public class GenreProcessorImpl extends BaseProcessorImpl<GenreParam,Genre,GenreResult,Long, GenreDao, GenreParamConverter,GenreResultConverter>
        implements GenreProcessor{

    @Override
    public Long getPK(GenreParam ent) {
        return  ent.getId();

    }
}
