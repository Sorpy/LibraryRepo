package application.business.processor.genreprocessor;


import application.business.converter.genre.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Genre;
import application.dataaccess.dao.genredao.GenreDao;
import application.dataaccess.dao.genredao.GenreDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GenreProcessorImpl extends BaseProcessorImpl<GenreParam,Genre,GenreResult,Long, GenreDao, GenreParamConverter,GenreResultConverter>
        implements GenreProcessor{

}
