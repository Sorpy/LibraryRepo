package business.processor.authorprocessor;

import business.converter.author.*;
import data.entity.Author;
import dataaccess.dao.authordao.AuthorDao;
import dataaccess.dao.authordao.AuthorDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class AuthorProcessorImpl implements AuthorProcessor{
    private AuthorDao authorDao = new AuthorDaoImpl();
    private AuthorParamConverter authorParamConverter= new AuthorParamConverterImpl();
    private AuthorResultConverter authorResultConverter = new AuthorResultConverterImpl();


    @Override
    public AuthorResult create(AuthorParam param) {
        return authorResultConverter
                .convert(authorDao
                        .save(authorParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<AuthorResult> create(List<AuthorParam> param) {
        List<Author> authors = new ArrayList<>();
        List<AuthorResult> authorResults = new ArrayList<>();

        param.forEach
                (author -> authors.add
                        (authorParamConverter.convert(author,null)));
        authorDao.save(authors);
        authors.forEach
                (author -> authorResults.add
                        (authorResultConverter.convert(author)));

        return authorResults;
    }

    @Override
    public void update(Long id, AuthorParam param) {
        Author oldEntity = authorDao.find(id);
        if (oldEntity!=null){
            authorDao.update(authorParamConverter.convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<AuthorParam> param) {

    }

    @Override
    public void delete(Long id) {
        authorDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        authorDao.delete(idList);
    }

    @Override
    public AuthorResult find(Long id) {
        return authorResultConverter.convert
                (authorDao.find(id));
    }

    @Override
    public List<AuthorResult> find() {
        List<AuthorResult> authorResults = new ArrayList<>();
        authorDao.find()
                .forEach(author -> authorResults.add
                        (authorResultConverter.convert(author)));
        return authorResults;
    }
}
