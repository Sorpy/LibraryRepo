package presentation.service.authorservice;

import business.converter.author.AuthorParam;
import business.converter.author.AuthorResult;
import business.processor.authorprocessor.AuthorProcessor;
import business.processor.authorprocessor.AuthorProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class AuthorServiceImpl implements AuthorService{
    private Serialization serialization = new Serialization();
    private AuthorProcessor authorProcessor = new AuthorProcessorImpl();

    public AuthorProcessor getAuthorProcessor() {
        return authorProcessor;
    }

    public void setAuthorProcessor(AuthorProcessor authorProcessor) {
        this.authorProcessor = authorProcessor;
    }

    @Override
    public APIResponse findByPK(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(authorProcessor.find(id)));
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
            response.setText(serialization.serialization(authorResults));
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
            response.setText(serialization.serialization(authorResult));
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
            response.setText(serialization.serialization(authorProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, AuthorParam param) {
        APIResponse response = new APIResponse();
        authorProcessor.update(id,param);
        return response;
    }

    @Override
    public APIResponse update(List<AuthorParam> param) {
        return null;
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
