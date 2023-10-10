package entites;

public class FacialHair {

    private String color;
    private boolean haveBeard;
    private boolean haveMustache;

    public FacialHair() {
    }

    public FacialHair(boolean haveBeard, boolean haveMustache, String color) {
        this.color = color;
        this.haveBeard = haveBeard;
        this.haveMustache = haveMustache;
    }

    public String getColor() {
        return color;
    }

    public boolean isHaveBeard() {
        return haveBeard;
    }

    public boolean isHaveMustache() {
        return haveMustache;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHaveBeard(boolean haveBeard) {
        this.haveBeard = haveBeard;
    }

    public void setHaveMustache(boolean haveMustache) {
        this.haveMustache = haveMustache;
    }

    @Override
    public String toString() {
        return "FacialHair{" +
                "color='" + color + '\'' +
                ", haveBeard=" + haveBeard +
                ", haveMustache=" + haveMustache +
                '}';
    }
}

