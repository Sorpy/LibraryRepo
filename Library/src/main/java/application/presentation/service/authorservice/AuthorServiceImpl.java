package application.presentation.service.authorservice;

import application.business.converter.author.AuthorParam;
import application.business.converter.author.AuthorResult;
import application.business.processor.authorprocessor.AuthorProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/Author")
public class AuthorServiceImpl extends BaseServiceImpl<AuthorParam,AuthorResult,Long,AuthorProcessor> implements AuthorService{

}
