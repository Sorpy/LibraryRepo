package presentation.service.accountservice;

import business.converter.account.AccountParam;
import business.converter.account.AccountResult;
import business.processor.accountclientprocessor.AccountProcessor;
import business.processor.accountclientprocessor.AccountProcessorImpl;
import data.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import presentation.jsonconverter.Serialization;
import presentation.jsonconverter.SerializationImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private Serialization serializationImpl;
    @Autowired
    private AccountProcessor accountProcessor;

    @Override
    public APIResponse findByPK(Long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText
                    (serializationImpl.serialization
                            (accountProcessor.find(id)));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }


    @Override
    public APIResponse findByName(String name){
        APIResponse response = new APIResponse();
        try {
            List<AccountResult> accountClientResults = accountProcessor.find(name);
            response.setText(serializationImpl.serialization(accountClientResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    public APIResponse findByParameter(String name,String value){
        APIResponse response = new APIResponse();
        try {

            List<AccountResult> accountClientResults = accountProcessor.find(name, value.toLowerCase());
            response.setText(serializationImpl.serialization(accountClientResults));
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
            List<AccountResult> accountClientResults = accountProcessor.find();
            response.setText(serializationImpl.serialization(accountClientResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(AccountParam param) {
        APIResponse response = new APIResponse();
        try{
            AccountResult accountClientResult = accountProcessor.create(param);
            response.setText(serializationImpl.serialization(accountClientResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e);
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<AccountParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization
                    (accountProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(Long id, AccountParam param) {
        APIResponse response = new APIResponse();
        try {
            accountProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<AccountParam> param) {
        APIResponse response = new APIResponse();
        try {
            accountProcessor.update(param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse deleteById(Long id) {
        APIResponse response = new APIResponse();
        try {
            accountProcessor.delete(id);
            response.setResult(true);
            response.setText("deleted element with ID: " + id);
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse delete(List<Long> idList) {
        APIResponse response = new APIResponse();
        try {
            accountProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(AccountParam param) {

    }

    @Override
    public void validateParameters(List<AccountParam> param) {

    }
}
