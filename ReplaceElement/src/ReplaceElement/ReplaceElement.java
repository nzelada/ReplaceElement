/**
 * ************************************************************
 * Purpose/Description: <The program will search and replace element>
 * Author’s Panther ID: 
 * Certification: I hereby certify that this work is my own and none of it is
 * the work of any other person.
 * ************************************************************
 */
package ReplaceElement;

import java.util.*;

public class ReplaceElement {

    static ArrayList<Integer> index; // new array list

    /**
     * This is a constructor method
     */
    public ReplaceElement() {
        this.index = new ArrayList<Integer>(); // assigns array list
    }

    /**
     * Another constructor but with a parameter
     *
     * @param items gets the items from the list
     */
    public ReplaceElement(ArrayList<Integer> elements) {

        this.index = elements; // assigning elements
        buildHeap(); // makes heap
    }

    /**
     * This method would move i to the position it should be in
     *
     * @param element the new element being placed
     */
    public void insert(int element) {
        index.add(element); // adds element to the array list
        int i = index.size() - 1; // assigns one less of the size
        int parent = parent(i); // makes parent whatever i is

        while (parent != i && index.get(i) < index.get(parent)) { // while loop

            swap(i, parent); // makes a swap
            i = parent; // makes parent to u
            parent = parent(i); // another swap
        }
    }

    /**
     * Makes the heap
     */
    public void buildHeap() {

        for (int i = index.size() / 2; i >= 0; i--) { // for loop
            minHeapify(i);
        }
    }

    /**
     * replaces the old key with new if only it is in the list
     *
     * @param oldKey old element
     * @param newKey new element that is replacing the old with
     */
    public void replaceKey(int oldKey, int newKey) {
        boolean found = false; // variable
        int i; // use for integers 
        for (i = 0; i < index.size(); i++) { // for loop
            if (index.get(i) == oldKey) { // checks if the key is found
                found = true; // if true, this break
                break;
            }
        }
        if (found == true) { // if found

            index.set(i, newKey); // replace it with the new one

            buildHeap(); // make the new heap

        } else {
            System.out.println(oldKey + " is not in the list."); // if not found
        }
    }

    /**
     * Looks for the smallest heap
     *
     * @param i the element
     */
    private void minHeapify(int i) {

        int left = left(i);
        int right = right(i);
        int smallest = -1;

// for loop
        if (left <= index.size() - 1 && index.get(left) < index.get(i)) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= index.size() - 1 && index.get(right) < index.get(smallest)) {
            smallest = right;
        }

// if not the key isn't the smallest
        if (smallest != i) {

            swap(i, smallest);
            minHeapify(smallest);
        }
    }
/**
 * Checks to see if the list is empty or not
 * @return if the size is 0
 */
    public boolean isEmpty() {

        return index.size() == 0;
    }
/**
 * The right node
 * @param i element
 * @return the number given by the formula
 */
    private int right(int i) {

        return 2 * i + 2;
    }
/**
 * Left node
 * @param i element
 * @return the number given by the formula
 */
    private int left(int i) {

        return 2 * i + 1;
    }
/**
 * Parent node
 * @param i
 * @return the number given by the formula
 */
    private int parent(int i) {

        if (i % 2 == 1) {
            return i / 2;
        }

        return (i - 1) / 2;
    }
/**
 * This method creates a swap
 * @param i element
 * @param parent node
 */
    private void swap(int i, int parent) {

        int temp = index.get(parent);
        index.set(parent, index.get(i));
        index.set(i, temp); // final swap
    }
/**
 * This is the main method in which it would bring the program together and run it
 * @param args 
 */
    public static void main(String args[]) {
        ReplaceElement myheap = new ReplaceElement();

        myheap.insert(4); // inserting to the list
        myheap.insert(6); // inserting to the list
        myheap.insert(7); // inserting to the list
        myheap.insert(32); // inserting to the list
        myheap.insert(19); // inserting to the list
        myheap.insert(64);// inserting to the list 
        myheap.insert(26); // inserting to the list
        myheap.insert(99);// inserting to the list
        myheap.insert(42);// inserting to the list
        myheap.insert(54);// inserting to the list
        myheap.insert(28);// inserting to the list
        System.out.println(index.toString().replace("[", "").replace("]", ""));
        //prints original list
        System.out.println("Replacing 54 with 2\n"); // print string
        myheap.replaceKey(54, 2); //calls the method and replaces it
        System.out.print(index.toString().replace("[", "").replace("]", "") + "\n");
        // new list being printed out
    }
}
