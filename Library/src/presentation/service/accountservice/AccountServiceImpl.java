package presentation.service.accountservice;

import business.converter.accountclient.AccountParam;
import business.converter.accountclient.AccountResult;
import business.processor.accountclientprocessor.AccountClientProcessor;
import business.processor.accountclientprocessor.AccountClientProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private Serialization serialization = new Serialization();
    private AccountClientProcessor accountClientProcessor = new AccountClientProcessorImpl();

    @Override
    public APIResponse findByPK(Long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText
                    (serialization.serialization
                            (accountClientProcessor.find(id)));
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
            List<AccountResult> accountClientResults = accountClientProcessor.find(name);
            response.setText(serialization.serialization(accountClientResults));
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

            List<AccountResult> accountClientResults = accountClientProcessor.find(name, value.toLowerCase());
            response.setText(serialization.serialization(accountClientResults));
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
            List<AccountResult> accountClientResults = accountClientProcessor.find();
            response.setText(serialization.serialization(accountClientResults));
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
            AccountResult accountClientResult = accountClientProcessor.create(param);
            response.setText(serialization.serialization(accountClientResult));
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
            response.setText(serialization.serialization
                    (accountClientProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(Long id, AccountParam param) {
        APIResponse response = new APIResponse();
        accountClientProcessor.update(id,param);

        return response;
    }

    @Override
    public APIResponse update(List<AccountParam> param) {
        return null;
    }

    @Override
    public APIResponse deleteById(Long id) {
        APIResponse response = new APIResponse();
        try {
            accountClientProcessor.delete(id);
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
            accountClientProcessor.delete(idList);
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
