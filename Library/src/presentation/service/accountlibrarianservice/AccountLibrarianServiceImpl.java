package presentation.service.accountlibrarianservice;

import business.converter.accountclient.AccountClientResult;
import business.converter.accountlibrarian.AccountLibrarianParam;
import business.converter.accountlibrarian.AccountLibrarianResult;
import business.processor.accountlibrarianprocessor.AccountLibrarianProcessor;
import business.processor.accountlibrarianprocessor.AccountLibrarianProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class AccountLibrarianServiceImpl implements AccountLibrarianService {
    private Serialization serialization = new Serialization();
    private AccountLibrarianProcessor accountLibrarianProcessor = new AccountLibrarianProcessorImpl();


    @Override
    public APIResponse findByPK(Long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(accountLibrarianProcessor.find(id)));
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
            List<AccountLibrarianResult> accountLibrarianResults = accountLibrarianProcessor.find(name);
            response.setText(serialization.serialization(accountLibrarianResults));
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
            List<AccountLibrarianResult> accountLibrarianResults = accountLibrarianProcessor.find();
            response.setText(serialization.serialization(accountLibrarianResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(AccountLibrarianParam param) {
        APIResponse response = new APIResponse();
        try {
            AccountLibrarianResult accountLibrarianResult = accountLibrarianProcessor.create(param);
            response.setText(serialization.serialization(accountLibrarianResult));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }


        @Override
    public APIResponse create(List<AccountLibrarianParam> param) {
            APIResponse response = new APIResponse();
            try{
                response.setResult(true);
                response.setText(serialization.serialization(accountLibrarianProcessor.create(param)));
            } catch(Exception e) {
                response.setText("Something went wrong " + e.getMessage());
                response.setResult(false);
            }
            return response;
        }

    @Override
    public APIResponse update(Long id, AccountLibrarianParam param) {
        APIResponse response = new APIResponse();
        accountLibrarianProcessor.update(id,param);

        return response;
    }

    @Override
    public APIResponse update(List<AccountLibrarianParam> param) {
        return null;
    }

    @Override
    public APIResponse deleteById(Long id) {
        APIResponse response = new APIResponse();
        try {
            accountLibrarianProcessor.delete(id);
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
            accountLibrarianProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(AccountLibrarianParam param) {

    }

    @Override
    public void validateParameters(List<AccountLibrarianParam> param) {

    }
}
