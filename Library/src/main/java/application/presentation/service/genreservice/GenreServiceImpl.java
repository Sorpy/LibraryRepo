package application.presentation.service.genreservice;

import application.business.converter.genre.GenreParam;
import application.business.converter.genre.GenreResult;
import application.business.processor.genreprocessor.GenreProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/Genre")
public class GenreServiceImpl extends BaseServiceImpl<GenreParam,GenreResult,Long,GenreProcessor> implements GenreService {

}
