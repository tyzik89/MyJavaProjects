import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonConverterFromJSON {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T convertFromJSONFile(File file, Class<T> valueType) throws IOException {
        T obj = objectMapper.readValue(file, valueType);
        return obj;
    }

    public <T> T convertFromJSONFile(String path, Class<T> valueType) throws IOException {
       return this.convertFromJSONFile(new File(path), valueType);
    }

    public <T> T convertFromJSONString(String jsonInString, Class<T> valueType) throws IOException {
        T obj = objectMapper.readValue(jsonInString, valueType);
        return obj;
    }
}
