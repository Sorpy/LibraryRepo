package presentation.service.genreservice;

import business.converter.genre.GenreParam;
import business.converter.genre.GenreResult;
import business.processor.genreprocessor.GenreProcessor;
import business.processor.genreprocessor.GenreProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private Serialization serialization = new Serialization();
    private GenreProcessor genreProcessor = new GenreProcessorImpl();

    public GenreProcessor getGenreProcessor() {
        return genreProcessor;
    }

    public void setGenreProcessor(GenreProcessor genreProcessor) {
        this.genreProcessor = genreProcessor;
    }

    @Override
    public APIResponse findByPK(long id){
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(genreProcessor.find(id)));
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
            List<GenreResult> genreResults = genreProcessor.find();
            response.setText(serialization.serialization(genreResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(GenreParam param) {
        APIResponse response = new APIResponse();
        try{
            GenreResult genreResult = genreProcessor.create(param);
            response.setText(serialization.serialization(genreResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<GenreParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serialization.serialization(genreProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, GenreParam param) {
        APIResponse response = new APIResponse();
        genreProcessor.update(id,param);
        return response;
    }

    @Override
    public APIResponse update(List<GenreParam> param) {
        return null;
    }

    @Override
    public APIResponse deleteById(long id) {
        APIResponse response = new APIResponse();
        try {
            genreProcessor.delete(id);
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
            genreProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(GenreParam param) {

    }

    @Override
    public void validateParameters(List<GenreParam> param) {

    }
}
