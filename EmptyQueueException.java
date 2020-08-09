/**
 * Thrown by methods in the Queue class to indicate that the Queue is empty.
 *
 * @author xsol05
 */
public class EmptyQueueException extends RuntimeException {

    /**
     * Version ID number for serialization.
     */
    private static final long serialVersionUID = 1;

    /**
     * Constructs a new EmptyQueueException with null as its error message
     * string.
     */
    public EmptyQueueException() {
        super();
    }

}
