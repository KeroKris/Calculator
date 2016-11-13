package se.keroprog.algorithmclass.calculator;


/**
 * Simple float stack that implements my own float List class,
 * has the options to put a new float, peek at the top of the stack
 * or pop the top of the stack from the stack.
 *
 * Created by Kristoffer on 2016-11-11.
 */
public class Stack {

    private List list = new List();


    /*
        Puts a Link at the top of the Stack containing the entered float.
     */
    public void put(float f){

        list.addFirst(f);
    }

    /*
        Looks at the top Link on the Stack and returns the value contained
        without removing the Link.
     */
    public float peek(){

        return list.getFirst();
    }

    /*
        Looks at the top Link on the Stack, returns the value contained and
        then removes it from the Stack.
     */
    public float pop(){
        float tempValue = this.peek();

        list.removeFirst();
        return tempValue;
    }

    /*
        Checks if the List is Empty.
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
