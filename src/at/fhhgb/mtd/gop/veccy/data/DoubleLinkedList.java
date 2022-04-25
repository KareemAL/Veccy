package at.fhhgb.mtd.gop.veccy.data;

import at.fhhgb.mtd.gop.veccy.shapes.Shape;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DoubleLinkedList implements Iterable<Shape>{
    private Node head, tail;

    // Entfernt Knoten an Stelle 'index'
    public Shape remove(int index) {
        if (index < 0 || index > size()-1) {
            return null;
        }
        else if (index == 0){
            return removeFirst();
            }
        else if (index == size()-1) {
            return removeLast();
        }

        Node node = this.getHead();
        int i = 0;

        while (i != index) {
            node = node.next;
            i++;
        }

        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        return node.value;
    }

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void clear () {
        head = null;
        tail = null;
    }

    // Prepend fügt einen neuen Knoten am Anfang der Liste ein
    public void prepend(Shape val) {
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
    public void append(Shape val) {
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

    public Shape get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("Index out of Bouds, weil bruh");
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
        throw new IndexOutOfBoundsException("Index out of Bouds, weil bruh");
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

    public Shape removeFirst () throws NoSuchElementException {
        Shape FinalShape = null;
        if (this.head != null && this.head.next == null) {
            FinalShape = this.head.value;
            head = null;
            tail = null;
        }
        else if (head != null) {
            FinalShape = this.head.value;
            this.head = this.head.next;
            this.head.prev = null;
        }
        if (FinalShape == null) {
            throw new NoSuchElementException("No such Element, bruh");
        }
        return FinalShape;
    }

    public Shape peekFirst () throws NoSuchElementException {
        Shape FinalShape = null;
        if (this.head != null) {
            FinalShape = this.head.value;
        }
        if (FinalShape == null) {
            throw new NoSuchElementException("No such Element, bruh");
        }
        return FinalShape;
    }

    public Shape removeLast () throws NoSuchElementException {
    Shape FinalShape = null;
        if (this.tail != null && this.tail.prev == null) {
            FinalShape = this.tail.value;
            head = null;
            tail = null;
        }
        else if (tail != null) {
            FinalShape = this.tail.value;
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        if (FinalShape == null) {
            throw new NoSuchElementException("No such Element, bruh");
        }
        return FinalShape;
    }

    public Shape peekLast () throws NoSuchElementException {
        Shape FinalShape = null;
        if (this.tail != null) {
            FinalShape = this.tail.value;
        }
        if (FinalShape == null) {
            throw new NoSuchElementException("No such Element, bruh");
        }
        return FinalShape;
    }

    public void reverse () {
        Node currentNode = this.head;
        while (currentNode != null) {
            Node currentNode2 = currentNode.next;
            currentNode.next = currentNode.prev;
            currentNode.prev = currentNode2;
            currentNode = currentNode2;
        }
        Node currentNode3 = this.head;
        this.head = this.tail;
        this.tail = currentNode3;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    @Override
    public Iterator<Shape> iterator() {
        return new DoubleLinkedListIterator(this.head);
    }

    @Override
    public void forEach(Consumer<? super Shape> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Shape> spliterator() {
        return Iterable.super.spliterator();
    }

}