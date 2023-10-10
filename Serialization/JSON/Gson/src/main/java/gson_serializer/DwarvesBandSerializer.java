package gson_serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import entites.Dwarf;
import entites.DwarvesBand;

import java.lang.reflect.Type;

public class DwarvesBandSerializer implements JsonSerializer<DwarvesBand> {

    public JsonElement serialize(DwarvesBand src, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        for (Dwarf dwarf : src.getDwarves()) {
            result.add(dwarf.getName(), context.serialize(dwarf));
        }

        return result;
    }
}
