package at.fhhgb.mtd.gop.veccy.data;

public class Node {
    public Node next;
    public Node prev;
    public int value;

    public Node() {
        this(0);
    }

    public Node(int value) {
        this.value = value;
    }
}
