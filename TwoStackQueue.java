import java.util.*;

/**
 * A class which implements the Queue interface.
 *
 * @author xsol05
 */
public class TwoStackQueue<E> implements Queue<E> {

    /** Left stack. */
    private Stack<E> left = new Stack<>();    
    /** Right stack. */
    private Stack<E> right = new Stack<>();
    // Shortcut: Don't need to write <E> for initialising

    /**
     * Return true if and only if this Queue is empty.
     *
     * @return true if this Queue is empty, otherwise false.
     */
    public boolean isEmpty() {
        return left.empty() && right.empty();
    }

    /**
     * Return the length of this Queue.
     *
     * @return the number of items in this Queue.
     */
    public int size() {
        return left.size() + right.size();
    }

    /**
     * Return the item at the front of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E get() {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        return right.peek();
    }

    /**
     * Make this Queue empty.
     */
    public void clear() {
        left.clear();
        right.clear();
    }

    /**
     * Add an item to the rear of this Queue.
     *
     * @param item the item to be added to the rear of the Queue.
     */
    public void add(E item) {
        left.push(item);
    }

    /**
     * Remove and return the front item of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E remove() {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        return right.pop();
    }

    /**
     * Return a string representation of this queue ordered from front to back.
     *
     * @return a string representation of this Queue.
     */
    public String toString() {
        /* bottom of left stack/ start of left array */
        ListIterator<E> leftIterator = left.listIterator(0);
        /* top of right stack/ end of right array */
        ListIterator<E> rightIterator = right.listIterator(right.size());
        StringBuilder queueString = new StringBuilder();

        queueString.append("[");

        boolean seenFirst = false;
        
        while (rightIterator.hasPrevious()) {
        // because starting from end of array
            if (seenFirst) { // will be false the first time
                queueString.append(", ");
            }
            queueString.append(rightIterator.previous());
            seenFirst = true;
        }

        while (leftIterator.hasNext()) {
        // because starting from the start of array
            if (seenFirst) { // will be false the first time
                queueString.append(", ");
            }
            queueString.append(leftIterator.next());
            seenFirst = true;
        }

        queueString.append("]");

        return queueString.toString();
    }

    /**
     * Print in order the two stacks which make up.
     * the queue, from bottom to top of each stack
     *
     * @return The string version of the stacks
     */
    public String debug() { 
        return left.toString() + right.toString();
    }
}
