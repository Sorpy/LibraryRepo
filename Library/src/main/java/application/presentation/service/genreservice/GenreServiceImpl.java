package application.presentation.service.genreservice;

import application.business.converter.genre.GenreParam;
import application.business.converter.genre.GenreResult;
import application.business.processor.genreprocessor.GenreProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class GenreServiceImpl extends BaseServiceImpl<GenreParam,GenreResult,Long,GenreProcessor> implements GenreService {

}
