package application.presentation.service.accountstatusservive;

import application.business.converter.accountstatus.AccountStatusParam;
import application.business.converter.accountstatus.AccountStatusResult;
import application.business.processor.accountstatusprocessor.AccountStatusProcessor;
import application.data.common.APIResponse;
import application.presentation.jsonconverter.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AccountStatusServiceImpl implements AccountStatusService {
    @Autowired
    private Serialization serialization;
    @Autowired
    private AccountStatusProcessor accountStatusProcessor;


    @Override
    public APIResponse findByPK(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(accountStatusProcessor.find(id)));
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
            List<AccountStatusResult> accountClientResults = accountStatusProcessor.find();
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
            AccountStatusResult accountClientResult = accountStatusProcessor.create(param);
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
            response.setText(serialization.serialization(accountStatusProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, AccountStatusParam param) {
        APIResponse response = new APIResponse();
        try {
            accountStatusProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<AccountStatusParam> param) {
        APIResponse response = new APIResponse();
        try {
            accountStatusProcessor.update(param);
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
            accountStatusProcessor.delete(id);
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
            accountStatusProcessor.delete(idList);
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
