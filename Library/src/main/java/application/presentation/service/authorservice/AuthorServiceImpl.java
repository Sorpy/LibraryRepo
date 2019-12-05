package application.presentation.service.authorservice;

import application.business.converter.author.AuthorParam;
import application.business.converter.author.AuthorResult;
import application.business.processor.authorprocessor.AuthorProcessor;
import application.business.processor.authorprocessor.AuthorProcessorImpl;
import application.data.common.APIResponse;
import application.presentation.jsonconverter.SerializationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private SerializationImpl serializationImpl;
    @Autowired
    private AuthorProcessor authorProcessor;

    @Override
    public APIResponse findByPK(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serializationImpl.serialization(authorProcessor.find(id)));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse listAll() {
        APIResponse response = new APIResponse();
        try {
            List<AuthorResult> authorResults = authorProcessor.find();
            response.setText(serializationImpl.serialization(authorResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(AuthorParam param) {
        APIResponse response = new APIResponse();
        try{
            AuthorResult authorResult = authorProcessor.create(param);
            response.setText(serializationImpl.serialization(authorResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<AuthorParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization(authorProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, AuthorParam param) {
        APIResponse response = new APIResponse();
        try {
            authorProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<AuthorParam> param) {
        APIResponse response = new APIResponse();
        try {
            authorProcessor.update(param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse deleteById(long id) {
        APIResponse response = new APIResponse();
        try {
            authorProcessor.delete(id);
            response.setResult(true);
            response.setText("deleted element with ID: " + id);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse delete(List<Long> idList) {
        APIResponse response = new APIResponse();
        try {
            authorProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(AuthorParam param) {

    }

    @Override
    public void validateParameters(List<AuthorParam> param) {

    }
}
