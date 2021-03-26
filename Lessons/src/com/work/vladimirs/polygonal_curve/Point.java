

public class Point implements Comparable<Point>{

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int compareTo(Point otherPoint) {
        int diffX = this.getX() - otherPoint.getX();
        if (diffX == 0 ) {
            int diffY = this.getY() - otherPoint.getY();
            return diffY != 0 ? (diffY / Math.abs(diffY)) : 0;
        }
        return (diffX / Math.abs(diffX));
    }
}
