package presentation.service.bookservice;

import business.converter.book.BookParam;
import business.converter.book.BookResult;
import business.processor.bookprocessor.BookProcessor;
import business.processor.bookprocessor.BookProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.SerializationImpl;

import java.util.List;

public class BookServiceImpl implements BookService{
    private SerializationImpl serializationImpl = new SerializationImpl();
    private BookProcessor bookProcessor = new BookProcessorImpl();

    public BookProcessor getBookProcessor() {
        return bookProcessor;
    }

    public void setBookProcessor(BookProcessor bookProcessor) {
        this.bookProcessor = bookProcessor;
    }

    @Override
    public APIResponse findByPK(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serializationImpl.serialization(bookProcessor.find(id)));
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
            List<BookResult> bookResults = bookProcessor.find();
            response.setText(serializationImpl.serialization(bookResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(BookParam param) {
        APIResponse response = new APIResponse();
        try{
            BookResult bookResult = bookProcessor.create(param);
            response.setText(serializationImpl.serialization(bookResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<BookParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization(bookProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, BookParam param) {
        APIResponse response = new APIResponse();
        try {
            bookProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<BookParam> param) {
        APIResponse response = new APIResponse();
        try {
            bookProcessor.update(param);
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
            bookProcessor.delete(id);
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
            bookProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(BookParam param) {

    }

    @Override
    public void validateParameters(List<BookParam> param) {

    }
}
