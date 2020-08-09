# Two-Stack-Queue
_Using two stacks to implement a queue_

### Background
The basic idea is to illustrate that a queue can be represented by a pair of stacks called (say) left and right. To insert into the queue they represent, you push onto the left stack. To remove from the queue, you pop from the right stack unless the right stack is empty in which case you first transfer, by pop and push operations, the entire left stack into the right stack.

### Details
**- TwoStackQueue**: This class implements the Queue interface. It also has an additional debug() method which concatenates the results of calling the toString() methods of the left and right stacks, and returns that string. This will verify that the stacks are being used correctly.  
**- QueueApp**: This application class reads lines of input from _stdin_ and handles it based on the choices given in the list below. It also checks that the queue is not empty before calling any methods which could throw an EmptyQueueException.

    KEY: input - action
    
    - a item, item... - Add the given item(s) to the back of your queue (in left to right order)
    - c - Clear the queue
    - d - Print out the result of calling the debug() method
    - g - Get and print the item at the front of the queue (if there is one)
    - p - Print out the result of calling the toString() method
    - r - Remove (and print) the item from the front of the queue (if there is one)
    - s - Print out the size of the queue

### Demonstration
**Sample input**  
    a one two 3  
    d  
    p  
    r  
    d  
    a 4 5 6  
    d  
    p  
    
**Corresponding output**  
    [one, two, 3][]  
    [one, two, 3]  
    one  
    [][3, two]  
    [4, 5, 6][3, two]  
    [two, 3, 4, 5, 6]  
