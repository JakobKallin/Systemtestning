package se.newton;

public class Triangles {
    public static boolean isIsoscelesTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return a == b || a == c || b == c;
    }
}
