package application.business.processor.authorprocessor;

import application.business.converter.author.*;
import application.data.entity.Author;
import application.dataaccess.dao.authordao.AuthorDao;
import application.dataaccess.dao.authordao.AuthorDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AuthorProcessorImpl implements AuthorProcessor{
    @Autowired
    private AuthorDao authorDao ;
    @Autowired
    private AuthorParamConverter authorParamConverter;
    @Autowired
    private AuthorResultConverter authorResultConverter;


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
        List<Author> authors = new ArrayList<>();
        param.forEach(author -> authors
                .add(authorParamConverter
                        .convert(author,null)));
        authorDao.update(authors);
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
