package dataproject;
public class LRUCache {
 private LinkedList list;
 private HashTable table;
 private int size;
 private int capacity;

  public LRUCache(int capacity){
      this.capacity=capacity;
      this.table =new HashTable(capacity);
      this.list =new LinkedList();
  }

public void put(int key,String value){
  Node node = table.search(key);

   if (node != null) {
     node.value = value;
     list.moveToFront(node);
     return;
        }
   // if the cache is full
   if(size==capacity){
   Node removed =list.removeTail();
   table.remove(removed.key);
   size--;
   }
   //insertAtFront
   //o(1)
Node newNode = new Node(key, value);
list.insertAtFront(newNode);
table.insert(key, newNode);
     this.size++;
    }

 public String get(int key){
   Node n=table.search(key);
   if(n==null){
   return "not found";
   }
   list.moveToFront(n);
   return n.value;
 }

 public void remove(int key){
  Node n=table.search(key);
  if(n!=null)
    {
    list.removeNode(n);
    table.remove(key);
  size--;
  }
 }
 
 public void display(){
   list.display();
 }

}
