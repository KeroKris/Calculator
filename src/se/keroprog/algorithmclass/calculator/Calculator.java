package se.keroprog.algorithmclass.calculator;


import java.util.Scanner;

/**
 * The Calculator Class contains the calculate method that takes a String expected to be a
 * postfix math problem and solves it, returning the answer.
 * The init method creates a console loop that asks for an input and runs calculate on the
 * given String. This gives the option to have the program explain the steps it takes during
 * the calculation.
 * Created by Kristoffer on 2016-11-11.
 */
public class Calculator {

    // Setting this to true will enable the console printout
    // of the process for the calculate(input) method
    private static boolean help = false;


    /**
     * Interactive Calculator that will ask for a postfix math problem
     * and return the answer. Entering Q will terminate the program.
     */
    public static void init(){

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the postfix calculator.");
        System.out.println("Do you want the calculations described? (Y/N)");


        String postfixProblem = "";
        help = input.nextLine().toLowerCase().equals("y");

        while (!postfixProblem.equals("q")){

            System.out.println("Please enter a math problem in postfix format, ex: (2.5 3.5 + 4 2 - *), Q for exit");
            System.out.print("calc>");

            postfixProblem = input.nextLine().toLowerCase();

            //If the String is a q, the loop terminates
            if (postfixProblem.contains("q")){
                System.out.println("Done calculating.");
            }
            //otherwise run the calculate method
            else{
                System.out.println("\nresult = " + calculate(postfixProblem) + "\n");
            }
        }
    }


    /**
     * The actual calculating method. Takes a String and splits it into an array and feeds
     * the split Strings to a Stack unless it is an operator (+, -, *, /).
     * If this is the case, it will pull the top two numbers from the stack and perform
     * the operator on them in postfix order.
     * @param input a String in the format of (x y [operator]) or similar.
     */
    public static String calculate(String input){
        Stack stack = new Stack();

        String[] tempArray;
        tempArray = input.trim().split(" ");


        for (int i = 0; i < tempArray.length; i++) {

            float tempFloat;

            try{ // Would prefer to catch NullPointers in the List class, but hope this will do for now

            //Checks if the next String is an operator, if so, performs the calculation
            switch (tempArray[i]){

                //if help is wanted, the operations will be provided in the console
                case "+":

                    tempFloat = stack.pop();
                    if (help) System.out.println(stack.peek() + " + " + tempFloat + " = " + (stack.peek() + tempFloat));
                    tempFloat = stack.pop() + tempFloat;
                    if (help) System.out.println("putting " + tempFloat + " on the stack");
                    stack.put(tempFloat);
                    break;

                case "-":
                    tempFloat = stack.pop();
                    if (help)System.out.println(stack.peek() + " - " + tempFloat + " = " + (stack.peek() - tempFloat));
                    tempFloat = stack.pop() - tempFloat;
                    if (help) System.out.println("putting " + tempFloat + " on the stack");
                    stack.put(tempFloat);
                    break;

                case "/":
                    tempFloat = stack.pop();
                    if (help) System.out.print(stack.peek() + " / " + tempFloat);
                    tempFloat = stack.pop() / tempFloat;
                    stack.put(tempFloat);

                    if (help){
                        System.out.println(" = " + tempFloat);
                        System.out.println("putting " + tempFloat + " on the stack");
                    }
                    break;

                case "*":
                    tempFloat = stack.pop();
                    if (help) System.out.print(stack.peek() + " * " + tempFloat);
                    tempFloat = stack.pop() * tempFloat;
                    stack.put(tempFloat);

                    if (help){
                        System.out.println(" = " + tempFloat);
                        System.out.println("putting " + tempFloat + " on the stack");
                    }
                    break;

                //if no operator, the String that is assumed to contain a valid float is put on the stack
                default:
                    if (help) System.out.println("putting " + tempArray[i] + " on the stack");
                    stack.put(Float.parseFloat(tempArray[i]));
                    break;
            }

            }catch (NullPointerException e){
                // catching NullPointers when peeking at an empty stack, most likely because of bad input syntax.
                System.out.println("Illegal postfix syntax, try again!");
                return "";
            }catch (NumberFormatException e){
                // Catching NumberFormatExceptions when trying to convert a String that is not a float.
                System.out.println("Illegal characters found, try again!");
                return "";
            }
        }

        // The calculator finally returns the top of the Stack
        if (!stack.isEmpty())
            return String.valueOf(stack.peek());

        return "";
    }
}
