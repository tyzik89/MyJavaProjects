import java.io.File;
import java.io.IOException;

public class JacksonExample2 {

    public static void main(String[] args) {
        JacksonConverterFromJSON converter = new JacksonConverterFromJSON();

        try {
            Staff staffFromFile = converter.convertFromJSONFile("D:\\staff.json", Staff.class);
            System.out.printf("staffFromFile: [[ %s ]]\n\n", staffFromFile.toString());

            String jsonInString = "{\"name\":\"mkyong\",\"age\":37,\"skills\":[\"java\",\"python\",\"c++\"]}";
            Staff staffFromString = converter.convertFromJSONString(jsonInString, Staff.class);
            System.out.printf("staffFromString: [[ %s ]]\n", staffFromString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
