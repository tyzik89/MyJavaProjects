package fractal;

public class AttractorOfLorenz implements Fractal {

    private final double sigma;
    private final double r;
    private final double b;
    private double x;
    private double y;
    private double z;
    private final double dt;
    private final int iterations;

    private AttractorOfLorenz(Builder builder) {
         sigma = builder.sigma;
         r = builder.r;
         b = builder.b;
         x = builder.x;
         y = builder.y;
         z = builder.z;
         dt = builder.dt;
         iterations = builder.iterations;
    }


    private double dx(double x, double y, double z) {
        return -sigma * (x - y);
    }

    private double dy(double x, double y, double z) {
        return -x * z + r * x - y;
    }

    private double dz(double x, double y, double z) {
        return x * y - b * z;
    }

    private void update(double dt) {
        double xnew = x + dx(x, y, z) * dt;
        double ynew = y + dy(x, y, z) * dt;
        double znew = z + dz(x, y, z) * dt;
        x = xnew;
        y = ynew;
        z = znew;
    }

    @Override
    public int[][] create(int rows, int cols) {
        int[][] pixelsArray = new int[rows][cols];
        int col, row;

        for (int i = 0; i < iterations; i++) {
            update(dt);
            row = (int) Math.round(30 * x + 1000);
            col = (int) Math.round(30 * z + 100);

            pixelsArray[row][col] = 255;
        }

        return pixelsArray;
    }

    //Паттерн строитель
    public static class Builder {
        //Mandatory
        private final int iterations;
        //Optional
        private double sigma = 10;
        private double r = 28;
        private double b = 8 / 3;
        private double x = 10.0;
        private double y = 20.0;
        private double z = 35.0;
        private double dt = 0.001;

        public Builder(int iterations) {
            this.iterations = iterations;
        }

        public Builder setSigma(double val) {
            sigma = val;
            return this;
        }

        public Builder setR(double val) {
            r = val;
            return this;
        }

        public Builder setB(double val) {
            b = val;
            return this;
        }

        public Builder setX(double val) {
            x = val;
            return this;
        }

        public Builder setY(double val) {
            y = val;
            return this;
        }

        public Builder setZ(double val) {
            z = val;
            return this;
        }

        public Builder setDT(double val) {
            dt = val;
            return this;
        }

        public AttractorOfLorenz build() {
            return new AttractorOfLorenz(this);
        }
    }

    /*@Override
    public int[][] build(int rows, int cols) {
        int[][] pixelsArray = new int[rows][cols];

        double x = 3.051522, y = 1.582542, z = 15.62388, x1, y1, z1;
        double dt = 0.0001;
        int a = 5, b = 15, c = 1;

        int step = 1000000;
        int col, row;

        while (step > 0) {
            step--;
            x1 = x + a * (-x + y) * dt;
            y1 = y + (b * x - y - z * x) * dt;
            z1 = z + (-c * z + x * y) * dt;
            x = x1;
            y = y1;
            z = z1;

            row = (int) Math.round(19.3 * (y - x * 0.292893) + 320);
            col = (int) Math.round(-11 * (z + x * 0.292893) + 392);

            pixelsArray[row][col] = 255;
        }
        return pixelsArray;
    }*/
}
