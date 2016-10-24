/**
 * Node - A node for a stack data structure
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
public class Node<E> {
    private E element;
    private Node<E> previous;

    /**
     * creates an instance of a node
     * @param element   The data of the node
     * @param previous  The previous node in the stack
     */
    public Node(E element, Node<E> previous) {
        this.element = element;
        this.previous = previous;
    }

    /**
     * gets the data from the node
     * @return The element
     */
    public E getElement() {
        return element;
    }

    /**
     * Gets the previous node
     * @return the previous node
     */
    public Node<E> getPrevious() {
        return previous;
    }
}
