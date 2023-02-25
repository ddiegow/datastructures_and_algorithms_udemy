package LinkedListChallenge2;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
        // if the list is empty or the head is greater than input value, insert value at front
        if (isEmpty() || head.getValue() > value) {
            addToFront(value);
        }
        // if not, iterate list while value bigger than next element, then insert value in list
        else {
            IntegerNode iterator = head;
            while (iterator.getNext() != null && value > iterator.getNext().getValue()) {
                iterator = iterator.getNext();
            }
            IntegerNode newNode = new IntegerNode(value);
            if (iterator.getNext() != null) {
                newNode.setNext(iterator.getNext());
            }
            iterator.setNext(newNode);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
