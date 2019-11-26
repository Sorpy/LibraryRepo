package presentation.service.userservice;

import business.converter.user.UserParam;
import business.converter.user.UserResult;
import business.processor.userprocessor.UserProcessor;
import business.processor.userprocessor.UserProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.SerializationImpl;

import java.util.List;

public class UserServiceImpl implements UserService{
    private SerializationImpl serializationImpl = new SerializationImpl();
    private UserProcessor userProcessor = new UserProcessorImpl();

    @Override
    public APIResponse findByPK(long id){
        APIResponse response = new APIResponse();
        try {
            response.setText(serializationImpl.serialization(userProcessor.find(id)));
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
            List<UserResult> userResults = userProcessor.find();
            response.setText(serializationImpl.serialization(userResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(UserParam param) {
        APIResponse response = new APIResponse();
        try{
            UserResult userResult = userProcessor.create(param);
            response.setText(serializationImpl.serialization(userResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<UserParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization(userProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, UserParam param) {
        APIResponse response = new APIResponse();
        try {
            userProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<UserParam> param) {
        APIResponse response = new APIResponse();
        try {
            userProcessor.update(param);
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
            userProcessor.delete(id);
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
            userProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(UserParam param) {

    }

    @Override
    public void validateParameters(List<UserParam> param) {

    }
}
