import java.util.NoSuchElementException;

/**
 * Stack - A stack data structure for heap objects
 *
 * <pre>
 *
 * Assignment: #2
 * Course: ADEV-3001
 * Date Created: October 24, 2016
 *
 * Revision Log
 * Who          When    Reason
 * --------- ---------- ----------------------------------
 *
 * </pre>
 *
 * @author Chris Usick
 * @version 1.0
 *
 */
public class Stack<E> {
    private Node<E> head;
    private int size;

    /**
     * Constructs a new Stack
     */
    public Stack() {
        size = 0;
    }

    /**
     * Adds a new element onto the stack
     * @param element   element to add
     * @return          true if addition was successful
     */
    public boolean push(E element) {
        head = new Node<E>(element, head);
        size++;
        return true;
    }

    /**
     * Get the element on the top of the stack, return's exception if empty
     * @return  the element on the top of the stack
     */
    public E top() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return head.getElement();
    }

    /**
     * Take an element off of the stack, throws exception if empty
     * @return  the element removed from the stack
     */
    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        Node<E> current = head;
        head = head.getPrevious();
        size--;
        return current.getElement();
    }

    /**
     * Gets the size of the stack
     * @return the size of the stack
     */
    public int size() {
        return size;
    }

    /**
     * returns whether or not the stack is empty
     * @return  true if the stack is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
