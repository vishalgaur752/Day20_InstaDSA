public class DeleteAllOccurance {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("dll is empty.");
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

    public static Node deletAllOcc(Node head, int x) {
        while(head != null && head.data == x) {
           head = head.next;
        }
        if(head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data == x) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteAllOccurance dll = new DeleteAllOccurance();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.print();
        int x = 2;
        head = deletAllOcc(head, x);
        dll.print();
    }
}
