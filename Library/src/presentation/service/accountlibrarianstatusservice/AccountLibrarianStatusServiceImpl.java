package presentation.service.accountlibrarianstatusservice;

import business.converter.accountlibrarianstatus.AccountLibrarianStatusParam;
import business.converter.accountlibrarianstatus.AccountLibrarianStatusResult;
import business.processor.accountlibrarianstatusprocessor.AccountLibrarianStatusProcessor;
import business.processor.accountlibrarianstatusprocessor.AccountLibrarianStatusProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class AccountLibrarianStatusServiceImpl implements AccountLibrarianStatusService{
    private Serialization serialization = new Serialization();
    private AccountLibrarianStatusProcessor accountLibrarianStatusProcessor = new AccountLibrarianStatusProcessorImpl();

    public AccountLibrarianStatusProcessor getAccountLibrarianStatusProcessor() {
        return accountLibrarianStatusProcessor;
    }

    public void setAccountLibrarianStatusProcessor(AccountLibrarianStatusProcessor accountLibrarianStatusProcessor) {
        this.accountLibrarianStatusProcessor = accountLibrarianStatusProcessor;
    }

    @Override
    public APIResponse findByPK(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(accountLibrarianStatusProcessor.find(id)));
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
            List<AccountLibrarianStatusResult> accountLibrarianStatusResults = accountLibrarianStatusProcessor.find();
            response.setText(serialization.serialization(accountLibrarianStatusResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(AccountLibrarianStatusParam param) {
        APIResponse response = new APIResponse();
        try{
            AccountLibrarianStatusResult accountLibrarianResult = accountLibrarianStatusProcessor.create(param);
            response.setText(serialization.serialization(accountLibrarianResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<AccountLibrarianStatusParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serialization.serialization(accountLibrarianStatusProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, AccountLibrarianStatusParam param) {
        APIResponse response = new APIResponse();
        accountLibrarianStatusProcessor.update(id,param);
        return response;
    }

    @Override
    public APIResponse update(List<AccountLibrarianStatusParam> param) {
        return null;
    }

    @Override
    public APIResponse deleteById(long id) {
        APIResponse response = new APIResponse();
        try {
            accountLibrarianStatusProcessor.delete(id);
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
            accountLibrarianStatusProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(AccountLibrarianStatusParam param) {

    }

    @Override
    public void validateParameters(List<AccountLibrarianStatusParam> param) {

    }
}
