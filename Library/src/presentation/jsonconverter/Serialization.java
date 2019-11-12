package presentation.jsonconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class Serialization {
    public String serialization (Object obj){
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String jsonStr= "";

        try {
            jsonStr= mapper.writeValueAsString(obj);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }


}
