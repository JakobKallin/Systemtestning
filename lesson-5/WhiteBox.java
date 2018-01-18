public class WhiteBox {
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