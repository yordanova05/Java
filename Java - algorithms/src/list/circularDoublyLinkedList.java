package list;

public class circularDoublyLinkedList {
    static class Node {
        int data;
        Node next, prev;

        public Node(int data) {
            this.data = data;
        }
    }

    static class CircularList {
        Node head;

        void add(int d) {
            Node n = new Node(d);
            if (head == null) {              // ако е празен списък
                head = n;
                n.next = n.prev = n;         // сочи към себе си
            } else {                         // ако има елементи
                Node last = head.prev;
                last.next = n;
                n.prev = last;
                n.next = head;
                head.prev = n;
            }
        }

        void show() {
            if (head == null) return;
            Node t = head;
            do {
                System.out.print(t.data + " ");
                t = t.next;
            } while (t != head);
            System.out.println();
        }
    }

        public static void main(String[] args) {
            CircularList list = new CircularList();
            list.add(10);
            list.add(20);
            list.add(30);
            list.show(); // Извежда: 10 20 30
        }
}