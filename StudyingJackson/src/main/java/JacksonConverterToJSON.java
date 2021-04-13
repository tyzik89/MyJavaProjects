import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JacksonConverterToJSON {

    private ObjectMapper objectMapper = new ObjectMapper();

    public void convertToJSON(File file, Object obj) throws IOException {

        // ignore all null fields globally
        // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Java objects to JSON file
        objectMapper.writeValue(file, obj);
        // Java objects to JSON string - compact-print
        String jsonString = objectMapper.writeValueAsString(obj);
        System.out.printf("jsonString: [[ %s ]]\n\n",jsonString);

        // Java objects to JSON string - pretty-print
        String jsonStringPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.printf("jsonStringPretty: [[ %s ]]\n\n", jsonStringPretty);
    }

    public void convertToJSON(String path, Object obj) throws IOException {
        this.convertToJSON(new File(path), obj);
    }

    public void convertToJSONWithView(Object obj) throws IOException {

        // to enable pretty print
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // normal
        String jsonStringNormalView = objectMapper
                .writerWithView(CompanyViews.Normal.class)
                .writeValueAsString(obj);
        System.out.printf("jsonStringNormalView: [[ %s ]]\n\n", jsonStringNormalView);


        // manager
        String jsonStringManagerView = objectMapper
                .writerWithView(CompanyViews.Manager.class)
                .writeValueAsString(obj);
        System.out.printf("jsonStringManagerView: [[ %s ]]\n\n", jsonStringManagerView);

    }
}
