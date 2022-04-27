package at.fhhgb.mtd.gop.veccy.data;

import at.fhhgb.mtd.gop.veccy.shapes.Shape;

import java.util.Iterator;

public class DoubleLinkedListIterator implements Iterator<Shape> {

    private Node currentNode;
    private Node head;

    public DoubleLinkedListIterator (Node head) {
        this.head = head;
        this.currentNode = head;
    }

    @Override
    public boolean hasNext() {
        if (this.currentNode != null) {
            return true;
        }
        return false;
    }

    @Override
    public Shape next() {
        Shape helpShape = currentNode.value;
        if (currentNode != null) {
            this.currentNode = this.currentNode.next;
        }
        return helpShape;
    }
}