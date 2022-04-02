package at.fhhgb.mtd.gop.veccy.data;

public class DoubleLinkedList {
    private Node head, tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    // Prepend fügt einen neuen Knoten am Anfang der Liste ein
    public void prepend(int val) {
        Node newNode = new Node();
        newNode.value = val;

        // 1. Fall: Liste ist leer, also ist head == null
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // 2. Fall: List ist NICHT leer, also ist head != null
        this.head.prev = newNode;
        newNode.next = this.head;
        this.tail = this.head;
        this.head = newNode;

    }

    //Append fügt einen neuen Knoten am Ende der Liste ein
    public void append(int val) {
        Node newNode = new Node();
        newNode.value = val;

        // 1. Fall: Liste ist leer, also ist tail == null
        if(this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // 2. Fall: List ist NICHT leer, also ist tail != null
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        if(this.head == null) {
            this.head = newNode;
        }
    }

    public int get(int index) {
        if(index < 0 || index > this.size()) {
            return Integer.MIN_VALUE;
        }
        Node node = this.head;
        int currentIndex = 0;
        while(node != null) {
            if(currentIndex == index) {
                return node.value;
            }

            currentIndex++;
            node = node.next;
        }
        return Integer.MIN_VALUE;
    }

    //Gibt zurück, wie viele Elemente in der Liste liegen
    public int size() {
        Node node = this.head;
        int x = 0;
        while(node != null) {
            x = x + 1;
            node = node.next;
        }
        return x;
    }
}

/* Oben in Uebungsstunde - Unten Selbst */

//package at.fhhgb.mtd.gop.veccy.data;
//
//public class DoubleLinkedList {
//    private Node head, tail;
//
//    public DoubleLinkedList() {
//        this.head = this.tail = null;
//    }
//
//    public DoubleLinkedList(int... values) {
//        this();
//        for (int i : values) this.append(i);
//    }
//
//    public DoubleLinkedList(DoubleLinkedList node) {
//        this.head = node.head;
//        this.tail = node.tail;
//    }
//
//    public void clear() {
//        this.head = this.tail = null;
//    }
//
//    public void prepend(int val) {
//        Node newNode = new Node();
//        if (this.head == null) {
//            this.tail = newNode;
//        } else {
//            this.head.prev = newNode;
//            newNode.next = this.head;
//        }
//        this.head = newNode;
//    }
//
//    public void append(int val) {
//        Node newNode = new Node();
//        if (this.tail == null) {
//            this.head = newNode;
//        } else {
//            this.tail.next = newNode;
//            newNode.prev = this.tail;
//        }
//        this.tail = newNode;
//    }
//
//    public int get(int index) {
//        if (this.head == null || this.tail == null) return Integer.MIN_VALUE;
//        Node current = this.head;
//        if (index > 0) {
//            for (int i = 0; i < index; i++) current = current.next;
//        } else if (index < 0) {
//            current = tail;
//            for (int i = 0; i > index; i--) current = current.prev;
//        }
//        return current.value;
//    }
//
//    public int removeFirst() {
//        if (this.head == null) return Integer.MIN_VALUE;
//        int value = this.head.value;
//        this.head = this.head.next;
//        this.head.prev = null;
//        return value;
//    }
//
//    public int peekFirst() {
//        return head == null ? Integer.MIN_VALUE : this.head.value;
//    }
//
//    public int removeLast() {
//        if (tail == null) return Integer.MIN_VALUE;
//        int value = this.tail.value;
//        this.tail = this.tail.prev;
//        this.tail.next = null;
//        return value;
//    }
//
//    public int peekLast() {
//        return tail == null ? Integer.MIN_VALUE : this.tail.value;
//    }
//
//    public int size() {
//        Node nodeSize = this.head;
//        int inc;
//        for (inc = 0; nodeSize != null; inc++) nodeSize = nodeSize.next;
//        return inc;
//    }
//
//    public void reverse() {
//        DoubleLinkedList reversedNode = new DoubleLinkedList();
//        for (int i = 0; i < this.size(); i++) reversedNode.prepend(this.get(i));
//        this.replaceNode(reversedNode);
//    }
//
//    public void replaceNode(DoubleLinkedList node) {
//        this.head = node.head;
//        this.tail = node.tail;
//    }
//
//    public int[] getAll() {
//        int[] arnold = new int[this.size()];
//        for (int i = 0; i < this.size(); i++) arnold[i] = this.get(i);
//        return arnold;
//    }
//
//    public Node getHead() {
//        return head;
//    }
//
//    public Node getTail() {
//        return tail;
//    }
//}
