package application.business.processor.genreprocessor;


import application.business.converter.genre.*;
import application.data.entity.Genre;
import application.dataaccess.dao.genredao.GenreDao;
import application.dataaccess.dao.genredao.GenreDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GenreProcessorImpl implements GenreProcessor{
    @Autowired
    private GenreDao genreDao;
    @Autowired
    private GenreParamConverter genreParamConverter;
    @Autowired
    private GenreResultConverter genreResultConverter ;

    @Override
    public GenreResult create(GenreParam param) {
        return genreResultConverter
                .convert(genreDao
                        .save(genreParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<GenreResult> create(List<GenreParam> param) {
        List<Genre> genres = new ArrayList<>();
        List<GenreResult> genreResults = new ArrayList<>();

        param.forEach(genreParam -> genres
                .add(genreParamConverter
                        .convert(genreParam,null)));
        genreDao.save(genres);
        genres.forEach(genre -> genreResults
                .add(genreResultConverter
                        .convert(genre)));

        return genreResults;
    }

    @Override
    public void update(Long id, GenreParam param) {
        Genre oldEntity = genreDao.find(id);
        if (oldEntity!=null){
            genreDao
                    .update(genreParamConverter
                            .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<GenreParam> param) {
        List<Genre> genres = new ArrayList<>();
        param.forEach(genreParam -> genres
                .add(genreParamConverter
                        .convert(genreParam,null)));
        genreDao.update(genres);
    }

    @Override
    public void delete(Long id) {
        genreDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        genreDao.delete(idList);
    }

    @Override
    public GenreResult find(Long id) {
        return genreResultConverter
                .convert(genreDao
                        .find(id));
    }

    @Override
    public List<GenreResult> find() {
        List<GenreResult> genreResults = new ArrayList<>();
        genreDao.find()
                .forEach(genre -> genreResults
                        .add(genreResultConverter
                                .convert(genre)));
        return genreResults;
    }
}
