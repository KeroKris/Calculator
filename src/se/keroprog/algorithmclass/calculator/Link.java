package se.keroprog.algorithmclass.calculator;

/**
 * Link Class to be used by the List class. Contains a float and a reference to the next Link in the List.
 * Created by Kristoffer on 2016-11-07.
 */
public class Link {
    float data;
    Link next;


     /*
        Constructor used by the addLast method when adding a new Link
        at the end of the List.
     */
    public Link(float data){
        this.data = data;
    }

    /*
        Constructor used by the addFirst method in the List Class.
        Used to add a Link at the start of the List, then sets its
        next reference to the previous first.
     */
    public Link(float data, Link next){
        this.data = data;
        this.next = next;
    }

    /*
        Recursive Method that iterates through the List to the last
        Link and adds a new Link containing the input data as the
        Link referenced as next.
     */
    public void addLast(float data) {
        if (this.next == null) next = new Link(data);
        else next.addLast(data);
    }
}
