package se.keroprog.algorithmclass.calculator;



public class Main {

    public static void main(String[] args) {



        //  Tests

        System.out.println(Calculator.calculate("2.5 3.5 + 4 2 - *"));

        System.out.println(Calculator.calculate("2 4 + +"));

        System.out.println(Calculator.calculate("2 4 A"));

        System.out.println(Calculator.calculate("2 4 !"));

        System.out.println(Calculator.calculate("6 2 / 2 2 + 3 * +"));

        Calculator.init();

    }
}
