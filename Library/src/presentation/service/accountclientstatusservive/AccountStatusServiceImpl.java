package presentation.service.accountclientstatusservive;

import business.converter.accountclientstatus.AccountStatusParam;
import business.converter.accountclientstatus.AccountStatusResult;
import business.processor.accountclientstatusprocessor.AccountClientStatusProcessor;
import business.processor.accountclientstatusprocessor.AccountClientStatusProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class AccountStatusServiceImpl implements AccountStatusService {
    private Serialization serialization = new Serialization();
    private AccountClientStatusProcessor accountClientStatusProcessor = new AccountClientStatusProcessorImpl();


    @Override
    public APIResponse findByPK(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(accountClientStatusProcessor.find(id)));
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
            List<AccountStatusResult> accountClientResults = accountClientStatusProcessor.find();
            response.setText(serialization.serialization(accountClientResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(AccountStatusParam param) {
        APIResponse response = new APIResponse();
        try{
            AccountStatusResult accountClientResult = accountClientStatusProcessor.create(param);
            response.setText(serialization.serialization(accountClientResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<AccountStatusParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serialization.serialization(accountClientStatusProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, AccountStatusParam param) {
        APIResponse response = new APIResponse();
        accountClientStatusProcessor.update(id,param);
        return response;
    }

    @Override
    public APIResponse update(List<AccountStatusParam> param) {
        return null;
    }

    @Override
    public APIResponse deleteById(long id) {
        APIResponse response = new APIResponse();
        try {
            accountClientStatusProcessor.delete(id);
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
            accountClientStatusProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(AccountStatusParam param) {

    }

    @Override
    public void validateParameters(List<AccountStatusParam> param) {

    }
}
