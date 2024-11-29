package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


class FibNum {
    /**
     * Fibonacci number
     */
    private int index;
    /**
     * the value of the Fibonacci number
     */
    private long value;



    /**
     *
     * @param index Fibonacci number
     * @param value the value of the Fibonacci number
     */
    public FibNum(int index, long value) {
        this.index = index;
        this.value = value;

    }

    /**
     *
     * @return the value of a number
     */

    public long getValue() {
        return value;
    }

    /**
     *
     * @return the Fibonacci number
     */
    public int getIndex() {
        return index;
    }

    public boolean isCubePlusOne() {
        long w = (long) Math.cbrt(value - 1);
        return (w * w * w  == value - 1 );
    }



    public String toString() {
        return "Число Фібоначчі #" + index + " = " + value;
    }
}

/**
 * class for generating Fibonacci numbers
 */
public class FibonacciChecker {
    /**
     *
     * @param n the first Fibonacci numbers
     * @return a list filled with prime Fibonacci numbers
     */
    public static List<FibNum> generateFibonacciNumbers(int n) {
        List<FibNum> fibonacciNumbers = new ArrayList<>();
        long a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            fibonacciNumbers.add(new FibNum(i, a));
           long next = a + b;
            a = b;
            b = next
            ;
        }

        return fibonacciNumbers;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість чисел Фібоначчі N: ");
        int n = scanner.nextInt();
        List<FibNum> fibonacciNumbers = generateFibonacciNumbers(n);


        System.out.print("\nПерші " + n + " чисел Фібоначчі:");
        for (FibNum fib : fibonacciNumbers) {
            System.out.println(fib);
        }

        System.out.println("\nЧисла Фібоначчі, які можна записати у вигляді w^3 + 1:");
        for (FibNum fib : fibonacciNumbers) {
            if (fib.isCubePlusOne()) {
                System.out.println(fib + " можна записати як w^3 + 1.");
            }
        }

    }
}
