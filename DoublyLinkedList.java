/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


public class DoublyLinkedList <E>
{
    public DoubleNode<E> head;


    public DoublyLinkedList()
    {
    }



    public void push(E someDataThing)
    {

    }
}


class DoubleNode<E>
{

    public E data;
    public DoublyLinkedList<E> forward;
    public DoublyLinkedList<E> backward;

    public DoubleNode(E data, DoublyLinkedList<E> forward, DoublyLinkedList<E> backward)
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

    public DoublyLinkedList<E> getForward()
    {
        return forward;
    }

    public void setForward(DoublyLinkedList<E> forward)
    {
        this.forward = forward;
    }

    public DoublyLinkedList<E> getBackward()
    {
        return backward;
    }

    public void setBackward(DoublyLinkedList<E> backward)
    {
        this.backward = backward;
    }
}
