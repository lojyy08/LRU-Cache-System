package dataproject;
public class LinkedList {
    private Node head;
    private Node tail;

public void insertAtFront(Node n){
if (head ==null ){
    head = tail = n;
    return;}
else{
    n.prev = null;
    n.next = head;
        head.prev =n;
        head = n;}
}

public void removeNode(Node node) {
    //empty
 if (node == null || head == null)
    return;

//remove head(most recently used)
if (head == node){
    head = head.next;

    //to disconnect with the prev node
    if (head != null){
    head.prev = null;
}else{
    //when it became an empty list we let tail=null)(it was unique item)
    tail = null;
}}

//remove tail(least recently used)
else if (tail == node) {
   tail = tail.prev;
   //there are still elements other than tail
  if (tail != null){
   //the new tail.next=null 
  tail.next = null;
}else {
//if tail = null (there was 1 element only in the list)  we make head also=null 
head = null;
}
}
//remove from middle
else {
//tell prev node to skip curr node and connect with the next node
node.prev.next = node.next;
//tell next node to disconnect with current node and connect with the prev node
node.next.prev = node.prev;
}
// we will return it (disconnect node from the list)
 node.next = null; 
 node.prev = null;
}
 public void moveToFront(Node node) {
        removeNode(node);
        insertAtFront(node);
}
// for LRU
 public Node removeTail() {
  if (tail == null) {
    return null;
}
  Node removed = tail;
  removeNode(tail);
  //disconnect the node with the next , prev node
  removed.next = null;
  removed.prev = null;
    return removed;
}


 public void display() {
  Node temp= head;
  while (temp!= null) {
  System.out.print(temp.value);
 if (temp.next != null){
    System.out.print(" <--> ");
}
   temp = temp.next;
        }
 System.out.println();
    }
}