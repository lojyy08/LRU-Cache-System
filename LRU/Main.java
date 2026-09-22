package dataproject;

public class Main {

    public static void main(String[] args) {
       System.out.println("=== LRU Cache Testing ===\n");
        LRUCache cache = new LRUCache(3);

        System.out.println("Test 1: Insert elements");
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.display();

        System.out.println("\nTest 2: Access key 1");
        cache.get(1);
        cache.display();


        System.out.println("\nTest 3: Insert key 4 (evict LRU)");
        cache.put(4, "D");
        cache.display();

        System.out.println("\nTest 4: Update key 3");
        cache.put(3, "C_updated");
        cache.display();



        System.out.println("\nTest 5: Remove key 4");
        cache.remove(4);
        cache.display();


        System.out.println("\nTest 6: Get non-existing key 99");
        System.out.println(cache.get(99));


        System.out.println("\nTest 7: Insert new key after remove");
        cache.put(5, "E");
        cache.display();

        System.out.println("\n=== End of Testing ===");
    }
}