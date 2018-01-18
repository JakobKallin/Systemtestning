public class WhiteBox {
    public static void a() {
        System.out.println("Hello");
    }

    public static void b(boolean x) {
        if (x) {
            System.out.println("Hello");
        }
    }

    public static void c(boolean x) {
        if (x) {
            System.out.println("Hello 1");
        }
        else {
            System.out.println("Hello 2");
        }
    }

    public static void d(boolean x) {
        if (x) {
            System.out.println("Hello 1");
        }
        else {
            System.out.println("Hello 2");
        }
        System.out.println("Hello 3");
    }

    public static void e(boolean x, boolean y) {
        if (x) {
            System.out.println("Hello 1");
        }
        else {
            if (y) {
                System.out.println("Hello 2");
            }
        }
        System.out.println("Hello 3");
    }

    public static void f(boolean x, boolean y) {
        if (x) {
            System.out.println("Hello 1");
        }
        else {
            if (y) {
                System.out.println("Hello 2");
            }
            else {
                System.out.println("Hello 3");
            }
        }
        System.out.println("Hello 4");
    }

    public static void g(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.println("Hello " + i);
        }
    }

    public static void h(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                System.out.println("Hello " + i);
            }
        }
    }

    public static void i(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                System.out.println("Hello " + i);
            }
            else {
                System.out.println("Another hello " + i);
            }
        }
    }

    public static void j(String s, boolean x) {
        if (x) {
            System.out.println("Hello");
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                System.out.println("Hello " + i);
            }
        }
    }

    public static int russianMultiplication(int x, int y) {
        int result = 0;
        while (x != 0) {
            if (x % 2 != 0) {
                result = result + y ;
            }
            x = x / 2;
            y = y * 2;
        }
        return result;
    }
}
