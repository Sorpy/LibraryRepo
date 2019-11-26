package presentation.service.usersusergroupservice;

import business.converter.usersusergroup.UsersUserGroupParam;
import business.converter.usersusergroup.UsersUserGroupResult;
import business.processor.usersusergroupprocessor.UsersUserGroupProcessor;
import business.processor.usersusergroupprocessor.UsersUserGroupProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.SerializationImpl;

import java.util.List;

public class UsersUserGroupServiceImpl implements UsersUserGroupService{
    private SerializationImpl serializationImpl = new SerializationImpl();
    private UsersUserGroupProcessor usersUserGroupProcessor = new UsersUserGroupProcessorImpl();
    @Override
    public APIResponse findByPK(long id){
        APIResponse response = new APIResponse();
        try {
            response.setText(serializationImpl.serialization(usersUserGroupProcessor.find(id)));
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
            List<UsersUserGroupResult> usersUserGroupResults = usersUserGroupProcessor.find();
            response.setText(serializationImpl.serialization(usersUserGroupResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(UsersUserGroupParam param) {
        APIResponse response = new APIResponse();
        try{
            UsersUserGroupResult usersUserGroupResult = usersUserGroupProcessor.create(param);
            response.setText(serializationImpl.serialization(usersUserGroupResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<UsersUserGroupParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization(usersUserGroupProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, UsersUserGroupParam param) {
        APIResponse response = new APIResponse();
        try {
            usersUserGroupProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<UsersUserGroupParam> param) {
        APIResponse response = new APIResponse();
        try {
            usersUserGroupProcessor.update(param);
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
            usersUserGroupProcessor.delete(id);
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
            usersUserGroupProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(UsersUserGroupParam param) {

    }

    @Override
    public void validateParameters(List<UsersUserGroupParam> param) {

    }
}
