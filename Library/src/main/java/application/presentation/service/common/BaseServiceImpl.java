package application.presentation.service.common;

import application.business.converter.basepersistent.BaseParam;
import application.business.converter.basepersistent.BaseResult;
import application.business.processor.common.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public class BaseServiceImpl<IN extends BaseParam,OUT extends BaseResult,PK,
        PROCESSOR extends BaseProcessor<IN,OUT,PK>>
        implements BaseService<IN,PK> {

    @Autowired
    private PROCESSOR processor;

    @Override
    @GetMapping("/findByPK")
    public ResponseEntity<OUT> findByPK(@RequestBody PK id) {

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

    @Override
    @GetMapping("/findByParameter")
    public ResponseEntity<List<OUT>> findByParameter(@RequestParam(name = "name") String name,@RequestParam String value){
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

    @Override
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

    @Override
    @PostMapping("/create")
    public ResponseEntity<OUT> create(@RequestBody IN param) {
        try{
            if (param == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(processor.create(param),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping("/createList")
    public ResponseEntity<List<OUT>> create(@RequestBody List<IN> param) {
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

    @Override
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestParam(name = "id") PK id,@RequestBody IN param) {
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

    @Override
    @PutMapping("/updateList")
    public ResponseEntity updateList(@RequestBody List<IN> param) {
        try {
            if (param == null){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            } else {
                processor.update(param);
                return new ResponseEntity(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/deleteById")
    public ResponseEntity deleteById(@RequestBody PK id) {

        try {
            if (id==null || (Long)id<=0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                processor.delete(id);
                return new ResponseEntity(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/deleteList")
    public ResponseEntity delete(@RequestBody List<PK> idList) {
        try {
            if (idList==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                processor.delete(idList);
                return new ResponseEntity(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void validateParameters(IN param) {

    }

    @Override
    public void validateParameters(List<IN> param) {

    }
}
