import java.util.List;

class BinarySearchTree<T extends Comparable<T>>
{

    private Node<T> root;

    void insert(T value)
    {

        /*
        if (this.root == null)
        {
            this.root = new Node<>(value, null, null);
        } else
        {
            T someValue = this.root.getData();
            if (value.compareTo(someValue) < 0) //left Node
            {
                if (this.root.getLeft() == null)
                {
                    this.root.left = new Node<>(value, null, null);
                } else
                {
                    root = this.root.getLeft();
                    this.insert(value);
                }
            } else
            {
                if (this.root.getRight() == null)
                {
                    this.root.right = new Node<>(value, null, null);
                } else
                {
                    root = this.root.getRight();
                    this.insert(value);
                }
            }
            //this.insert(root.getData());
        }
        */
         
    }

    private void insertHelper(Node<T> aNode, T someValue)
    {
        T leafValue = aNode.getData();

        if (aNode.isLeaf())
        {
            if (someValue.compareTo(leafValue) < 0)
            {
                aNode.left = new Node<>(someValue, null, null);
            }
            else
            {
                aNode.right = new Node<>(someValue, null, null);
            }
        }
        else
        {
            if (someValue.compareTo(leafValue) < 0)
            {
                if (aNode.left == null)
                {
                    aNode.left = new Node<>(someValue, null, null);
                }
                else
                {
                    insertHelper(aNode.left, someValue);
                }
            }
            else
            {
                if (aNode.right == null)
                {
                    aNode.right = new Node<>(someValue, null, null);
                }
                else
                {
                    insertHelper(aNode.right, someValue);
                }
            }
        }
    }

    List<T> getAsSortedList()
    {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList()
    {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Node<T> getRoot()
    {
        return this.root;
    }

    static class Node<T>
    {

        private T data;
        private Node<T> left, right;

        public Node(T aData, Node<T> aLeft, Node<T> aRight)
        {
            this.data = aData;
            this.left = aLeft;
            this.right = aRight;

        }

        Node<T> getLeft()
        {
            return this.left;
        }

        Node<T> getRight()
        {
            return this.right;
        }

        T getData()
        {
            return this.data;
        }

        private boolean isLeaf()
        {
            return left == null && right == null;
        }

    }
}
