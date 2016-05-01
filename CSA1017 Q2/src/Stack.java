import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mark on 14/02/16.
 */
public class Stack<E> extends ArrayList {

    public Stack() {
    }

    public Stack(Collection<? extends E> c) {
        super(c);
    }

    public void push(E data) {
        int prevSize = this.size();
        this.add(data);

        if (this.size() == prevSize + 1) return true;
        else return false;
    }

    public E pop() {
        if (this.size() == 0) return null;
        else return (E) this.remove(this.size() - 1);
    }

    public E peek() {
        if (this.size() == 0) return null;
        else return (E) this.get(this.size() - 1);
    }

    public String toString() {
        if (this.size() == 0) return "Stack is empty";
        else return super.toString();
    }
}
