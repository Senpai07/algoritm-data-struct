package ru.geekbrains.ads.lesson5.homework;

// 2 ^ 3 = 2 * 2 * 2 = 8
public class Exponentiation {

    public static void main(String[] args) {
        System.out.println(pow(2, 3));
        System.out.println(pow(-2, 3));
        System.out.println(pow(-2, 0));

        System.out.println("------------");
        System.out.print("2 ^ 3 = ");
        System.out.println(exp(2, 3));
        System.out.print("-2 ^ 3 = ");
        System.out.println(exp(-2, 3));
        System.out.print("2 ^ 0 = ");
        System.out.println(exp(2, 0));
        System.out.print("2 ^ -3 = ");
        System.out.println(exp(2, -3));
        System.out.print("0 ^ 3 = ");
        System.out.println(exp(0, 3));
        System.out.print("0 ^ -3 = ");
        System.out.println(exp(0, -3));
    }

    // Без возможности возведения в отрицательную степень
    private static int pow(int a, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be 0 or positive value!");
        }
        if (n == 0) {
            return 1;
        }
        return (n != 1) ? a * pow(a, n - 1) : a;
    }

    // С возможностью возведения в отрицательную степень
    private static double exp(double a, int n) {
        if (a == 0) {
            if (n < 0) {
                throw new IllegalArgumentException("0^(-n) wrong values!");
            } else if (n == 0) {
                return 0;
            }
        }

        if (n < 0) {
            return 1 / (a * exp(a, -n - 1));
        } else if (n > 0) {
            return a * exp(a, n - 1);
        } else return 1;
    }
}
