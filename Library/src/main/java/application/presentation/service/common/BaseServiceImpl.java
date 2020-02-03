package application.presentation.service.common;

import application.business.converter.basepersistent.BaseParam;
import application.business.converter.basepersistent.BaseResult;
import application.business.processor.common.BaseProcessor;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid request, no data retrieved"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})

public class BaseServiceImpl<IN extends BaseParam,OUT extends BaseResult,PK,
        PROCESSOR extends BaseProcessor<IN,OUT,PK>>
        implements BaseService<IN,PK> {

    @Autowired
    private PROCESSOR processor;

    /**
     * Method used for finding an Entity by its ID
     * @param id to search for entity
     * @return Return entity with the given ID.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entity with specified ID successfully returned")
    })
    @Override
    @ApiOperation("Find entity by PK")
    @GetMapping("/findByPK")
    public ResponseEntity<OUT> findByPK(@RequestHeader(name = "Authorization")@ApiParam("PK to be searched by.")
                                              @RequestBody PK id) {

        try {
            if (id==null || (Long)id<=0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            else {
                return new ResponseEntity<>(processor.find(id), HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method used for finding an Entity by a field and a value
     * @param name Gives a field name to search by
     * @param value Value to search for in the specified field
     * @return List Returns all entities with the in the value searched for.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entity with specified field and value successfully returned")
    })
    @Override
    @ApiOperation("Find Entity by a value of a column")
    @GetMapping("/findByParameter")
    public ResponseEntity<List<OUT>> findByParameter(
            @RequestHeader(name = "Authorization")
            @ApiParam("Field to be searched by.")@RequestParam String name,
            @ApiParam("Value of the specified.")@RequestParam String value){
        try {
            if (name == null || value == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<>(processor.find(name, value),HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method Listing all entities from the table
     * @return List Returns all objects with the in the value searched for.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of entities stored successfully returned")
    })
    @Override
    @ApiOperation("List all entities")
    @GetMapping("/listAll")

    public ResponseEntity<List<OUT>> listAll() {
        try {
            List<OUT> results = processor.find();
            if (results == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            else {
            return new ResponseEntity<>(results,HttpStatus.OK);
                }
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method used for creating and adding a new Entity in the DB
     * @param param Gives value for an entity that will be created
     * @return Returns the saved entity.
     */

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Entity successfully created")
    })
    @Override
    @ApiOperation("Create an entity")
    @PostMapping("/create")
    public ResponseEntity<OUT> create(
            @ApiParam("Param that's being sent to the database") @RequestBody IN param) {
        try{
            if (param == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(processor.create(param),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method used for creating and adding a new Entity in the DB
     * @param param Gives a List of entities that is going to be saved.
     * @return Returns all saved entities.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Entities successfully created")
    })
    @Override
    @ApiOperation("Create a List of entities")
    @PostMapping("/createList")
    public ResponseEntity<List<OUT>> create(
            @ApiParam("List of params that's being sent to the database")@RequestBody List<IN> param) {
        try{
            if (param==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
            return new ResponseEntity<>(processor.create(param),HttpStatus.OK);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method used for updating Entity in the DB
     * @param id ID of an Entity that's going to be updated.
     * @param param Gives an Entity that's going to be updated.
     * @return Returns response that entities are updated.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Entity successfully updated")
    })
    @Override
    @ApiOperation("Update an Entity")
    @PutMapping("/update")
    public ResponseEntity<String> update(
            @ApiParam("PK of an element being updated")@RequestParam PK id,
            @ApiParam("Param that's being updated")@RequestBody IN param) {
        try {
            if (id == null || param == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                processor.update(id,param);
                return new ResponseEntity<>("Updated",HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method used for updating entities in the DB
     * @param param Gives a List of entities that is going to be updated.
     * @return Returns all saved entities.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Entities successfully updated")
    })
    @Override
    @ApiOperation("Deletes a List of entities")
    @PutMapping("/updateList")
    public ResponseEntity<String> updateList(
            @ApiParam("List of params being updated")@RequestBody List<IN> param) {
        try {
            if (param == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                processor.update(param);
                return new ResponseEntity<>("Entities successfully",HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Method used for deleting an Entity by its ID
     * @param id ID of entity that's going to be deleted
     * @return Return entity with the given ID.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Entity successfully with set id successfully deleted")
    })
    @Override
    @ApiOperation("Deletes a List of entities")
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(
            @ApiParam("PK of entity that's being deleted")@RequestBody PK id) {

        try {
            if (id==null || (Long)id<=0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                processor.delete(id);
                return new ResponseEntity<>("Element deleted",HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method used for deleting an Entity by its ID
     * @param idList List of entities that's going to be deleted
     * @return Return entity with the given ID.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Entities successfully with set ids successfully deleted")
    })
    @Override
    @ApiOperation("Deletes a List of entities")
    @DeleteMapping("/deleteList")
    public ResponseEntity<String> delete(
            @ApiParam("List of IDs of entities that are being deleted")@RequestBody List<PK> idList) {
        try {
            if (idList==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                processor.delete(idList);
                return new ResponseEntity<>("List of entities successfully deleted",HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void validateParameters(IN param) {

    }

    @Override
    public void validateParameters(List<IN> param) {

    }
}
