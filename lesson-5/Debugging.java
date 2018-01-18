public class Debugging {
    public static int sum(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            result += n;
        }
        doSomething();
        return result;
    }

    public static void doSomething() {
        System.out.println("Hello");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int[] values = {5, 7, 3};
        int result = sum(values) + add(1, 2);
    }
}
