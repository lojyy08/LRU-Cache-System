package dataproject;

class Node {
    int key;
    String value;
    Node prev;
    Node next;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
