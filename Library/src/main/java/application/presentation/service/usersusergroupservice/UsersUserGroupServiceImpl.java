package application.presentation.service.usersusergroupservice;

import application.business.converter.usersusergroup.UsersUserGroupParam;
import application.business.converter.usersusergroup.UsersUserGroupResult;
import application.business.processor.usersusergroupprocessor.UsersUserGroupProcessor;
import application.business.processor.usersusergroupprocessor.UsersUserGroupProcessorImpl;
import application.data.common.APIResponse;
import application.presentation.jsonconverter.SerializationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UsersUserGroupServiceImpl implements UsersUserGroupService{
    @Autowired
    private SerializationImpl serializationImpl;
    @Autowired
    private UsersUserGroupProcessor usersUserGroupProcessor;

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
