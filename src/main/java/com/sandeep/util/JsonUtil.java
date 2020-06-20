package com.sandeep.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Convert an Object to Json and Json to object
 * 
 * @author raychaud
 *
 */
public class JsonUtil {

    private JsonUtil() {

    }

    /**
     * Convert the Object to Json format
     * 
     * @param object
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static String toJson( Object object ) throws JsonGenerationException,
            JsonMappingException, IOException {
    	String jsonString = null;
    	if(null != object) {
    		ObjectMapper objectMapper = new ObjectMapper();
    		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    		jsonString = objectMapper.writeValueAsString( object );
    	}
    	return jsonString;
    }

    /**
     * Convert Json to object
     * 
     * @param object
     * @param valueType
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static < T > T convertFromJson( String object, Class< T > valueType )
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue( object, valueType );
    }
    
       
	
}
