public class RemoveDuplicates {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void print() {
        // if(head == null) {
        // System.out.println("dll is empty.");
        // return;
        // }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node removeDuplicates(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (prev.data == curr.data) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicates dll = new RemoveDuplicates();
        dll.addLast(1);
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(3);
        System.out.println("Before removing duplicates:");
        dll.print();

        head = removeDuplicates(head);
        System.out.println("After removing duplicates:");
        dll.print();
    }
}