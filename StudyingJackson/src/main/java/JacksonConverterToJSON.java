import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonConverterToJSON {

    private ObjectMapper objectMapper = new ObjectMapper();

    public void convertToJSON(File file, Object obj) throws IOException {
        // Java objects to JSON file
        objectMapper.writeValue(file, obj);
        // Java objects to JSON string - compact-print
        String jsonString = objectMapper.writeValueAsString(obj);
        System.out.printf("jsonString: [[ %s ]]\n\n",jsonString);

        // Java objects to JSON string - pretty-print
        String jsonStringPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.printf("jsonStringPretty: [[ %s ]]\n", jsonStringPretty);
    }

    public void convertToJSON(String path, Object obj) throws IOException {
        this.convertToJSON(new File(path), obj);
    }
}
