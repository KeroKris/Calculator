package se.keroprog.algorithmclass.calculator;

/**
 * Simple Linked List for floats made to contain any number of Links
 * Can add and remove at both the beginning and the end.
 * Created by Kristoffer on 2016-11-07.
 */
public class List {

    private Link first = null;



    public boolean isEmpty(){
        if (first == null) return true;
        return false;
    }

    public float getFirst() {

        return first.data;
    }

    public void addFirst(float data){
        first = new Link(data, first);
    }

    public void removeFirst() {
        if (!isEmpty()) {
            first = first.next;
        }
    }

    public void addLast(float data){
        if (first == null) first = new Link(data);
        else{
            first.addLast(data);
        }
    }

    public void removeLast(){
        if (!isEmpty()){
            if (first.next == null){
                first = null;
            }
            Link help1 = first;
            Link help2 = first.next;
            while (help2.next != null){
                help1 = help2;
                help2 = help2.next;
            }
            help1.next = null;
        }
    }
}
