package presentation.service.usergroupstatusservice;

import business.converter.usergroupstatus.UserGroupStatusParam;
import business.converter.usergroupstatus.UserGroupStatusResult;
import business.processor.usergroupstatusprocessor.UserGroupStatusProcessor;
import business.processor.usergroupstatusprocessor.UserGroupStatusProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.SerializationImpl;

import java.util.List;

public class UserGroupStatusServiceImpl implements UserGroupStatusService{
    private SerializationImpl serializationImpl = new SerializationImpl();
    private UserGroupStatusProcessor userGroupStatusProcessor = new UserGroupStatusProcessorImpl();

    @Override
    public APIResponse findByPK(Long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText
                    (serializationImpl.serialization
                            (userGroupStatusProcessor.find(id)));
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
            List<UserGroupStatusResult> accountClientResults = userGroupStatusProcessor.find();
            response.setText(serializationImpl.serialization(accountClientResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(UserGroupStatusParam param) {
        APIResponse response = new APIResponse();
        try{
            UserGroupStatusResult userGroupStatusResult = userGroupStatusProcessor.create(param);
            response.setText(serializationImpl.serialization(userGroupStatusResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e);
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<UserGroupStatusParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization
                    (userGroupStatusProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(Long id, UserGroupStatusParam param) {
        APIResponse response = new APIResponse();
        try {
            userGroupStatusProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<UserGroupStatusParam> param) {
        APIResponse response = new APIResponse();
        try {
            userGroupStatusProcessor.update(param);
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
            userGroupStatusProcessor.delete(id);
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
            userGroupStatusProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(UserGroupStatusParam param) {

    }

    @Override
    public void validateParameters(List<UserGroupStatusParam> param) {

    }
}
