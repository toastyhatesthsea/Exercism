/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


public class DoublyLinkedList<E>
{
    public DoubleNode<E> head, tail;


    public DoublyLinkedList()
    {
    }


    /**
     * Adds data at the top of the Linked List
     * @param someDataThing E
     */
    public void push(E someDataThing)
    {
        if (head == null)
        {
            head = new DoubleNode<>(someDataThing);
            tail = head;
        } else
        {
            DoubleNode<E> oldHead = head;
            DoubleNode<E> newHead = new DoubleNode<>(someDataThing);
            if (head == tail)
            {
                newHead.setBackward(head);
                head = newHead;
                oldHead.setForward(head);
                tail = oldHead;
            } else
            {
                newHead.setBackward(oldHead);
                oldHead.setForward(newHead);
                head = newHead;
            }
        }
    }

    /**
     * Adds data at tail end of Linked List
     * @param someData E
     */
    public void unshift(E someData)
    {
        if (head == null)
        {
            head = new DoubleNode<>(someData);
            tail = head;
        }
        else
        {
            DoubleNode<E> oldTail = tail;
            DoubleNode<E> newTail = new DoubleNode<>(someData);
            newTail.setForward(oldTail);
            oldTail.setBackward(newTail);
            tail = newTail;
        }
    }

    /**
     * Adds Removes data at tail end of Linked List
     * @return E
     */
    public E shift()
    {
        E answer = null;

        if (head == tail)
        {
            answer = head.getData();
            head = null;
        }
        else
        {
            answer = tail.getData();
            tail.getForward().setBackward(null);
            tail = tail.getForward();
        }

        return answer;
    }

    /**
     * Removed data at top/beginning of Linked List
     * @return E
     */
    public E pop()
    {
        E answer = null;
        if (head == tail)
        {
            answer = head.getData();
            head = null;
            tail = null;
        } else
        {
            answer = head.getData();
            head.getBackward().setForward(null);
            head = head.getBackward();

        }

        return answer;
    }
}

class MeowersTestersMeows
{
    public static void main(String[] asdasdasdasd)
    {
        DoublyLinkedList rawrs = new DoublyLinkedList();

        rawrs.push(12);
        rawrs.push("Meows");
        rawrs.push(999999);

        rawrs.pop();
        rawrs.pop();
        rawrs.pop();
    }
}


class DoubleNode<E>
{

    public E data;
    public DoubleNode<E> forward;
    public DoubleNode<E> backward;

    public DoubleNode(E data, DoubleNode<E> forward, DoubleNode<E> backward)
    {
        this.data = data;
        this.forward = forward;
        this.backward = backward;
    }

    public DoubleNode()
    {
    }

    public DoubleNode(E data)
    {
        this.data = data;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E data)
    {
        this.data = data;
    }

    public DoubleNode<E> getForward()
    {
        return forward;
    }

    public void setForward(DoubleNode<E> forward)
    {
        this.forward = forward;
    }

    public DoubleNode<E> getBackward()
    {
        return backward;
    }

    public void setBackward(DoubleNode<E> backward)
    {
        this.backward = backward;
    }
}
