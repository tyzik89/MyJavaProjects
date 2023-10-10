import entites.Dwarf;
import entites.DwarvesBand;
import entites.FacialHair;
import gson_desirializer.DwarfDeserializer;
import gson_desirializer.DwarvesBandDeserializer;
import gson_desirializer.FacialHairDeserializer;
import gson_serializer.DwarfSerializer;
import gson_serializer.DwarvesBandSerializer;
import gson_serializer.FacialHairSerializer;
import util.BandUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        DwarvesBand band = BandUtil.createBand();
        Gson gson;

        /*Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(band);
        System.out.println(json);*/

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
                .registerTypeAdapter(Dwarf.class, new DwarfSerializer())
                .registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
                .create();
        String json = gson.toJson(band);
        System.out.println(json);


        gson = new GsonBuilder()
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandDeserializer())
                .registerTypeAdapter(FacialHair.class, new FacialHairDeserializer())
                .registerTypeAdapter(Dwarf.class, new DwarfDeserializer())
                .create();
        DwarvesBand dwarvesBand = gson.fromJson(json, DwarvesBand.class);
        System.out.println("==============================");
        System.out.println(dwarvesBand.toString());
        System.out.println("==============================");
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        System.out.println(gson.toJson(dwarvesBand));
    }
}
