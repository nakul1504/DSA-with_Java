public class GCD {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + findGCD(num1, num2)); // Expected: 6

        num1 = 101;
        num2 = 103;
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + findGCD(num1, num2)); // Expected: 1
    }
}