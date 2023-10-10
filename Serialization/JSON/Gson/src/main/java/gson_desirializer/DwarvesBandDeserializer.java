package gson_desirializer;

import com.google.gson.*;
import entites.Dwarf;
import entites.DwarvesBand;

import java.lang.reflect.Type;
import java.util.Map;

public class DwarvesBandDeserializer implements JsonDeserializer<DwarvesBand> {

    public DwarvesBand deserialize(JsonElement jsonElement,
                                   Type type,
                                   JsonDeserializationContext context) throws JsonParseException {
        DwarvesBand result = new DwarvesBand();

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Dwarf dwarf = context.deserialize(entry.getValue(), Dwarf.class);
            dwarf.setName(entry.getKey());
            result.addDwarf(dwarf);
        }

        return result;
    }
}
