package application.presentation.service.accounttype;

import application.business.converter.accounttype.AccountTypeParam;
import application.business.converter.accounttype.AccountTypeResult;
import application.business.processor.accounttypeprocessor.AccountTypeProcessor;
import application.data.common.APIResponse;
import application.presentation.jsonconverter.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountTypeServiceImpl implements AccountTypeService{
    @Autowired
    private Serialization serialization;
    @Autowired
    private AccountTypeProcessor accountTypeProcessor;


    @Override
    public APIResponse findByPK(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(accountTypeProcessor.find(id)));
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
            List<AccountTypeResult> accountTypeResults = accountTypeProcessor.find();
            response.setText(serialization.serialization(accountTypeResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(AccountTypeParam param) {
        APIResponse response = new APIResponse();
        try{
            AccountTypeResult accountTypeResult = accountTypeProcessor.create(param);
            response.setText(serialization.serialization(accountTypeResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<AccountTypeParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serialization.serialization(accountTypeProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, AccountTypeParam param) {
        APIResponse response = new APIResponse();
        try {
            accountTypeProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<AccountTypeParam> param) {
        APIResponse response = new APIResponse();
        try {
            accountTypeProcessor.update(param);
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
            accountTypeProcessor.delete(id);
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
            accountTypeProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(AccountTypeParam param) {

    }

    @Override
    public void validateParameters(List<AccountTypeParam> param) {

    }
}
