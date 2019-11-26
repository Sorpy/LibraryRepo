package presentation.service.userstatusservice;

import business.converter.userstatus.UserStatusParam;
import business.converter.userstatus.UserStatusResult;
import business.processor.userstatusprocessor.UserStatusProcessor;
import business.processor.userstatusprocessor.UserStatusProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.SerializationImpl;

import java.util.List;

public class UserStatusServiceImpl implements UserStatusService{
    private SerializationImpl serializationImpl = new SerializationImpl();
    private UserStatusProcessor userStatusProcessor = new UserStatusProcessorImpl();

    @Override
    public APIResponse findByPK(long id){
        APIResponse response = new APIResponse();
        try {
            response.setText(serializationImpl.serialization(userStatusProcessor.find(id)));
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
            List<UserStatusResult> userResults = userStatusProcessor.find();
            response.setText(serializationImpl.serialization(userResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(UserStatusParam param) {
        APIResponse response = new APIResponse();
        try{
            UserStatusResult userStatusResult = userStatusProcessor.create(param);
            response.setText(serializationImpl.serialization(userStatusResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<UserStatusParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization(userStatusProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, UserStatusParam param) {
        APIResponse response = new APIResponse();
        try {
            userStatusProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<UserStatusParam> param) {
        APIResponse response = new APIResponse();
        try {
            userStatusProcessor.update(param);
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
            userStatusProcessor.delete(id);
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
            userStatusProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(UserStatusParam param) {

    }

    @Override
    public void validateParameters(List<UserStatusParam> param) {

    }
}
