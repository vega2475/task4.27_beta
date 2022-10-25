import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        System.out.println( "test value --->  " + isMonotonic(testReandNumber()));//test
        System.out.println("Монотонное число --> " + functionForCountNumbers());
    }

    static int readNumber() {
        Scanner scn = new Scanner(System.in);
        System.out.println(" Введите индекс n ");
        return scn.nextInt();
    }

    static int testReandNumber(){
        Scanner scn = new Scanner(System.in);
        System.out.print(" Введите тестовое значение для проверки на монотонность ");
        return scn.nextInt();
    }

    public static int functionForCountNumbers() {
        int n = readNumber();


        while (n < 0) {
            System.out.println("number shouldn't be negative");
            n = readNumber();
        }

        if (n <= 100) return n;

        int count = 100;
        int candidate = 100; // the first monotonic number, which should correspond to n = 100

        while (count < n) {

            if (isMonotonic(candidate)) count++;
            candidate++;
        }

        return candidate;
    }

    public static boolean isMonotonic(int num) {

        // NOTE: use Math.abs() to adjust the input if negative values are allowed

        if (num <= 99) return true; // early kill for small number

        int last = num % 10;
        int first = num / (int) Math.pow(10, (int) Math.log10(num));

        int prev = last;
        num /= 10;

        boolean isEqual = isEqual(first, last);
        boolean isIncreasing = isIncreasing(first, last);
        boolean isDeceasing = isDecreasing(first, last);

        while (num > 0) {
            int next = num % 10;

            if (isEqual && !isEqual(next, prev)) return false; // next is passed before previous because we are iterating from right to left

            if (isIncreasing != isIncreasing(next, prev) && isDeceasing != isDecreasing(next, prev)) {
                return false;
            }

            prev = next;
            num /= 10;
        }

        return true; // the number is proved to be monotonic
    }

    public static boolean isEqual(int left, int right) {
        return left == right;
    }

    public static boolean isIncreasing(int left, int right) {
        return left <= right;
    }

    public static boolean isDecreasing(int left, int right) {
        return left >= right;
    }
}