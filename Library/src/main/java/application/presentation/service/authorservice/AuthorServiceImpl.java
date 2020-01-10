package application.presentation.service.authorservice;

import application.business.converter.author.AuthorParam;
import application.business.converter.author.AuthorResult;
import application.business.processor.authorprocessor.AuthorProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class AuthorServiceImpl extends BaseServiceImpl<AuthorParam,AuthorResult,Long,AuthorProcessor> implements AuthorService{

}
