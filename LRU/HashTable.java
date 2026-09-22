package dataproject;
public class HashTable {

  private Entry[] table;//table of hash
  private int capacity; // max len of arr (hash)

    private static class Entry {
        int key;
        Node node;
        Entry next;

        Entry(int key, Node node) {
            this.key = key;
            this.node = node;
            this.next = null;
        }
    }

// hash with max len capacity
public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }
// hash f()
private int hash(int key) {
        return Math.abs(key) % capacity;
    }

 public void insert(int key, Node node) {
        int index = hash(key);
        Entry current = table[index]; // pointer starts from the 1st entry in bucket

        while (current != null) {
            if (current.key == key) {
                current.node = node; // update its node
                return;
            }
            current = current.next;
        }
//to make time complexity = o(1)
        Entry newEntry = new Entry(key, node);
        newEntry.next = table[index];// point at the current head entry
        table[index] = newEntry; // make the new head entry
    }

public Node search(int key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.node;
            }
            current = current.next;
        }

        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        Entry current = table[index];
        Entry prev = null;

        while (current != null) {
            if (current.key == key) {
                //in the first
                if (prev == null) {
                    table[index] = current.next;

                 //in middle or End
                } else {
                    prev.next = current.next;
                }
                return;
            }
            //moving currsor
          prev = current;
          current = current.next;
        }
    }
}
