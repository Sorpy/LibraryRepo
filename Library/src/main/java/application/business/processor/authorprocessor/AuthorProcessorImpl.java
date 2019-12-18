package application.business.processor.authorprocessor;

import application.business.converter.author.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Author;
import application.dataaccess.dao.authordao.AuthorDao;
import application.dataaccess.dao.authordao.AuthorDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AuthorProcessorImpl
        extends BaseProcessorImpl<AuthorParam,Author,AuthorResult,Long,
        AuthorDao,AuthorParamConverter,AuthorResultConverter>
        implements AuthorProcessor{

}
