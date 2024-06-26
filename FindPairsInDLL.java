import java.util.*;

public class FindPairsInDLL {
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

    public ArrayList<ArrayList<Integer>> findSumPair(Node head, int target) {
        Node tail = head;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (tail.next != null) {
            tail = tail.next;
        }
            while (head != tail) {
                if (head.data + tail.data == target) {
                    ArrayList<Integer> pairs = new ArrayList<>();
                    pairs.add(head.data);
                    pairs.add(tail.data);
                    ans.add(pairs);
                    tail= tail.prev;
                } else if(head.data + tail.data > target) {
                    tail = tail.prev;
                } else {
                    head = head.next;
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        FindPairsInDLL dll = new FindPairsInDLL();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.addLast(7);
        dll.addLast(8);
        dll.addLast(9);
        int target = 7;
        ArrayList<ArrayList<Integer>> pairs = dll.findSumPair(dll.head, target);
        for (ArrayList<Integer> pair : pairs) {
            System.out.println("(" + pair.get(0) + ", " + pair.get(1) + ")");
        }
    }
}
