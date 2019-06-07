package items;

public class Combo {

    private Item obj_1;
    private Item obj_2;
    private Item result;
    private String message;

    public Combo(Item obj_1, Item obj_2, Item result, String message) {
        this.obj_1 = obj_1;
        this.obj_2 = obj_2;
        this.result = result;
        this.message = message;
    }

    public Item getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public Item getObj_1() {
        return obj_1;
    }

    public Item getObj_2() {
        return obj_2;
    }
}
