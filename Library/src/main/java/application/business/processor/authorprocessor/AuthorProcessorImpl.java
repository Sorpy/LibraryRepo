package application.business.processor.authorprocessor;

import application.business.converter.author.AuthorParam;
import application.business.converter.author.AuthorParamConverter;
import application.business.converter.author.AuthorResult;
import application.business.converter.author.AuthorResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Author;
import application.dataaccess.dao.authordao.AuthorDao;
import org.springframework.stereotype.Component;
@Component
public class AuthorProcessorImpl
        extends BaseProcessorImpl<AuthorParam,Author,AuthorResult,Long,
        AuthorDao,AuthorParamConverter,AuthorResultConverter>
        implements AuthorProcessor{

    @Override
    public Long getPK(AuthorParam ent) {
        return  ent.getId();
    }
}
