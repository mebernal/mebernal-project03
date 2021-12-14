package stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of a stack based on a singly linked list. The head of the stack is stored at the head of the list,
 * allowing the stack to grow and shrink in constant time.
 * @author CS1C, Foothill College, Michael Bernal
 * @version 1.0
 */

public class StackList<E> implements Iterable<E>
{
    /**
     * Attributes
     */
    private String name;
    private int size;
    private Node top;

    /**
     * A constructor which takes and initializes the class attributes
     */
    StackList()
    {
        name = "";
        size = 0;
        top = null;
    }

    /**
     * A method called push() which takes a generic item as the argument and adds the item to the top of the stack.
     * @param item a generic item
     */
    public void push(E item)
    {
        if(item == null)
            return;

        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * A method called pop() which receives no arguments and removes the item from the top of the stack.
     * This method should return the generic item popped.
     * @return the generic item popped
     */
    public E pop()
    {
        Node tmp;
        tmp = top;

        if(isEmpty())
            return null;

        top = top.next;
        size--;
        return tmp.item;
    }

    /**
     * A method called peek which looks at the top of the stack and returns a generic type for the data seen
     * at the top of the stack. The item should not be removed from the top of the stack.
     * @return the generic item seen at the top of the stack
     */
    public E peek()
    {
        if(top == null)
            return null;

        return top.item;
    }

    /**
     * isEmpty() method checks to see if the top of the stack is empty
     * @return null
     */
    public boolean isEmpty()
    {
        return(top == null);
    }

    /**
     * size() method returns the size of the forward or back link
     * @return link size
     */
    public int size()
    {
        return size;
    }

    /**
     * toString() method returns item as a string
     * @return item as string
     */
    public String toString()
    {
        Node p;
        String str = "";

        for(p = top; p != null; p = p.next)
        {
            str += p.toString() + ", ";
        }
        return str;
    }

    /**
     * clear() method clears forwardLinks in setCurrentLink() method
     */
    public void clear()
    {
        top = null;
        size = 0;
    }

    /**
     * An inner class Node with attributes next of type Node and data of a generic type.
     */
    private class Node
    {
        Node next;
        E item;

        Node(E x)
        {
            item = x;
        }

        public String toString()
        {
            String str = item.toString();
            return str;
        }
    }

    /**
     * The inner StackIterator parameterized class which implements an the Iterator interface.
     * This provides an iterator over the outer generic StackList.
     */
    private class StackIterator implements Iterator<E>
    {
        private Node cur = top;

        public boolean hasNext()
        {
            return cur != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public E next()
        {
            if(!hasNext())
                throw new NoSuchElementException();

            E tmp = cur.item;
            cur = cur.next;
            return tmp;
        }
    }

    public Iterator<E> iterator()
    {
        return new StackIterator();
    }
}
