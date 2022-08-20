import java.io.Serializable;

/**
 * Project 4
 *
 *The myQueue class creates a linked list queue of all nodes.
 *
 * @author Yashvin Vedanaparti, Riley Turk, section 17
 *
 * @version 3/31/17
 *
 */
public class MyQueue implements Serializable
{
    int count;        //Count to reflect queue size
    Node head;        //Holds reference to start of queue
    Node rear;        //holds reference of tail

    public MyQueue()
    {
        head = null;
        count = 0;
        rear = null;
    }

    public void add(Object o)
    {
        Node temp = new Node(o);
        if(this.head == null)
        {
            this.head = temp;
            this.rear = temp;
            this.rear.setNext(null);
            count++;
            return;
        }
        try {
            rear.setNext(temp);
            temp.setPrev(rear);
            temp.setNext(null);
            rear = temp;
            count++;
        } catch(NullPointerException e){ e.printStackTrace();}


    }
    public Node remove()
    {
        Node temp = head;
        if(head == null) {
            return null;
        }
        if(head == rear)
        {
            head = null;
            rear = null;
            count--;
            return temp;
        }
        head = head.getNext();
        count--;
        return temp;
    }


    public Node peek()
    {
        return head;
    }
    public boolean isEmpty()
    {
        if(count == 0)
            return true;

        return false;
    }
    public int size()
    {
        return count;
    }


}
