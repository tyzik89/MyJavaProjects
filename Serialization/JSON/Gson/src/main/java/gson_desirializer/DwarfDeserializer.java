package gson_desirializer;

import com.google.gson.*;
import entites.Dwarf;
import entites.FacialHair;
import entites.UniqueWeapon;
import entites.Weapon;

import java.lang.reflect.Type;

public class DwarfDeserializer implements JsonDeserializer<Dwarf> {

    public Dwarf deserialize(JsonElement jsonElement,
                             Type type,
                             JsonDeserializationContext context) throws JsonParseException {
        Dwarf dwarf = new Dwarf();

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        dwarf.setDwarfAge(jsonObject.get("age").getAsInt());
        dwarf.setFacialHair((FacialHair) context.deserialize(jsonObject.get("facialHair"), FacialHair.class));

        JsonArray weapons = jsonObject.getAsJsonArray("weapons");
        for (JsonElement weapon : weapons) {
            if (weapon.isJsonPrimitive()) {
                dwarf.addWeapon(new Weapon(weapon.getAsString()));
            } else {
                dwarf.addWeapon((UniqueWeapon) context.deserialize(weapon, UniqueWeapon.class));
            }
        }

        return dwarf;
    }
}
