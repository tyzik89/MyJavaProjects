package gson_serializer;

import com.google.gson.*;
import entites.Dwarf;
import entites.UniqueWeapon;
import entites.Weapon;

import java.lang.reflect.Type;

public class DwarfSerializer implements JsonSerializer<Dwarf> {

    public JsonElement serialize(Dwarf src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        //result.addProperty("name", src.getName());
        result.addProperty("age", src.getDwarfAge());
        result.add("facialHair", context.serialize(src.getFacialHair()));

        JsonArray weapons = new JsonArray();
        result.add("weapons", weapons);
        for (Weapon weapon : src.getWeapons()) {
            weapons.add(
                    weapon instanceof UniqueWeapon ?
                            context.serialize(weapon) :
                            new JsonPrimitive(weapon.getType())
            );
        }

        return result;
    }
}
