package presentation.service.bookstatusservice;

import business.converter.bookstatus.BookStatusParam;
import business.converter.bookstatus.BookStatusResult;
import business.processor.bookstatusprocessor.BookStatusProcessor;
import business.processor.bookstatusprocessor.BookStatusProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.SerializationImpl;

import java.util.List;

public class BookStatusServiceImpl implements BookStatusService{
    private SerializationImpl serializationImpl = new SerializationImpl();
    private BookStatusProcessor bookStatusProcessor = new BookStatusProcessorImpl();

    public BookStatusProcessor getBookStatusProcessor() {
        return bookStatusProcessor;
    }

    public void setBookStatusProcessor(BookStatusProcessor bookStatusProcessor) {
        this.bookStatusProcessor = bookStatusProcessor;
    }

    @Override
    public APIResponse findByPK(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serializationImpl.serialization(bookStatusProcessor.find(id)));
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
            List<BookStatusResult> bookStatusResults = bookStatusProcessor.find();
            response.setText(serializationImpl.serialization(bookStatusResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(BookStatusParam param) {
        APIResponse response = new APIResponse();
        try{
            BookStatusResult bookStatusResult = bookStatusProcessor.create(param);
            response.setText(serializationImpl.serialization(bookStatusResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<BookStatusParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization(bookStatusProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, BookStatusParam param) {
        APIResponse response = new APIResponse();
        try {
            bookStatusProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<BookStatusParam> param) {
        APIResponse response = new APIResponse();
        try {
            bookStatusProcessor.update(param);
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
            bookStatusProcessor.delete(id);
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
            bookStatusProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(BookStatusParam param) {

    }

    @Override
    public void validateParameters(List<BookStatusParam> param) {

    }
}
