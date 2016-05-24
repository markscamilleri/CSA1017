import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * @author Mark Said Camilleri
 * @version 20160509
 * A stack implemented as an ArrayList to have it dynamically increase its size.
 */
public class Stack<E> extends ArrayList {

    /**
     * Default constructor. Calls the ArrayList default constructor
     */
    public Stack() {
        super();
    }

    /**
     * Initialised a stack with the contents of the Collection in the parameter.
     *
     * @param c the contents to initialise the stack with.
     */
    public Stack(Collection<? extends E> c) {
        super(c);
    }

    /**
     * Pushes the data onto the stack
     *
     * @param data data to be pushed on the stack
     * @throws IndexOutOfBoundsException if not sucessfully pushed
     */
    public void push(E data) throws IndexOutOfBoundsException {
        int prevSize = this.size();
        this.add(data);

        //Condition to check if the data has been successfully added.
        if (!(this.size() == prevSize + 1))
            throw new IndexOutOfBoundsException("Failed to push to stack");
    }

    /**
     * Pops the topmost item from the stack.
     * @return the data from the top of the stack is not empty.
     * @throws EmptyStackException if the stack is empty.
     */
    public E pop() throws ArrayIndexOutOfBoundsException {
        if (this.size() == 0) throw new EmptyStackException();
        else return (E) this.remove(this.size() - 1);
    }

    /**
     * Returns the data at the top of the stack without popping it.
     * @return the data if the stack is not empty. null if it is empty.
     */
    public E peek() {
        if (this.size() == 0) return null;
        else return (E) this.get(this.size() - 1);
    }

    /**
     * Returns a string representation of the contents of the stack.
     * @overrides toString() in class AbstractCollection<E>
     * @return The string representation of the ArrayList if not empty. "Stack is empty" if it is empty.
     */
    public String toString() {
        if (this.size() == 0) return "Stack is empty";
        else return super.toString();
    }
}
