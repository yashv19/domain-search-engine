import java.io.Serializable;

/**
 * Project 4
 *
 *Creates a node with a reference.
 *
 * @author Yashvin Vedanaparti, Riley Turk, section 17
 *
 * @version 3/31/17
 *
 */

public class Node extends Object implements Serializable
{
    private Object data;    //Data to be stored by this node
    private Node next;      //stores reference to the next node in the queue
    private Node prev;      //stores reference to previous node in the queue

    Node(Object obj)
    {
        this.data = obj;

    }
    public void setNext(Node next)
    {
        this.next = next;
    }
    public void setPrev(Node prev)
    {
        this.prev = prev;
    }
    public Node getNext()
    {
        return this.next;
    }
    public Node getPrev()
    {
        return this.prev;
    }
    public Object getData()
    {
        return this.data;
    }
}

