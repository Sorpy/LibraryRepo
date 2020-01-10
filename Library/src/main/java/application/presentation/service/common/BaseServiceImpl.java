package application.presentation.service.common;

import application.business.converter.basepersistent.BaseParam;
import application.business.converter.basepersistent.BaseResult;
import application.business.processor.common.BaseProcessor;
import application.data.common.APIResponse;
import application.presentation.jsonconverter.Serialization;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<IN extends BaseParam,OUT extends BaseResult,PK,
        PROCESSOR extends BaseProcessor<IN,OUT,PK>>
        implements BaseService<IN,PK> {

    @Autowired
    private Serialization serial;
    @Autowired
    private PROCESSOR processor;

    @Override
    public APIResponse findByPK(PK id) {
        APIResponse response = new APIResponse();
        try {
            response.setText
                    (serial.serialization
                            (processor.find(id)));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse findByParameter(String name,String value){
        APIResponse response = new APIResponse();
        try {

            List<OUT> results = processor.find(name, value.toLowerCase());
            response.setText(serial.serialization(results));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse listAll() {
        APIResponse response = new APIResponse();
        try {
            List<OUT> results = processor.find();
            response.setText(serial.serialization(results));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(IN param) {
        APIResponse response = new APIResponse();
        try{
            OUT result = processor.create(param);
            response.setText(serial.serialization(result));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e);
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<IN> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serial.serialization
                    (processor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(PK id, IN param) {
        APIResponse response = new APIResponse();
        try {
            processor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<IN> param) {
        APIResponse response = new APIResponse();
        try {
            processor.update(param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse deleteById(PK id) {
        APIResponse response = new APIResponse();
        try {
            processor.delete(id);
            response.setResult(true);
            response.setText("deleted element with ID: " + id);
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse delete(List<PK> idList) {
        APIResponse response = new APIResponse();
        try {
            processor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(IN param) {

    }

    @Override
    public void validateParameters(List<IN> param) {

    }
}
