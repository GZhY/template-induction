package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import templateGenerating.beans.InputBeans;

import java.io.File;
import java.io.IOException;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class JacksonHelper {
    public static InputBeans jsonFile2Beans(final String jsonFilePath) {
        InputBeans inputBeans = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            inputBeans = mapper.readValue(new File(jsonFilePath), InputBeans.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputBeans;
    }
}
