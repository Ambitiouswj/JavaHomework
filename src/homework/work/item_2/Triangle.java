package homework.work.item_2;

public class Triangle {
    private double a, b, c;

    public Triangle() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public int checkTriangle() {
        double x, y, z;
        if (a > b) {
            if (a > c) {
                x = a;
                if (b > c) {
                    y = b;
                    z = c;
                } else {
                    y = c;
                    z = b;
                }
            } else {
                x = c;
                y = a;
                z = b;
            }
        } else {
            if (b > c) {
                x = b;
                if (a > c) {
                    y = a;
                    z = c;
                } else {
                    y = c;
                    z = a;
                }
            } else {
                x = c;
                y = b;
                z = a;
            }
        }
        if (y + z < x || Math.abs(y + z - x) < 1e-8) return -1; //不构成三角形
        else if (Math.abs(x * x - y * y - z * z) < 1e-8) return 0; //直角三角形
        else if (x * x > y * y - z * z) return 1; //锐角三角形
        else return 2; //钝角三角形
    }
}
