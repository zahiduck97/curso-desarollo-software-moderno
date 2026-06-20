class LRUCache {
///////////// como swi fuera un archivo externo
    private static class Node {
        int key;
        int value;
        
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    ////////////////////////////////

    private final int capacity;
    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node currentNode = cache.get(key);

        removeNode(currentNode);
        addToFront(currentNode);

        return currentNode.value;
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(value)) {
            Node node = cache.get(key);
            node.value = value;

            removeNode(node);
            addToFront(node);

            return;
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToFront(newNode);

        if(cache.size() > capacity) {
            Node lastNode = tail.prev;

            removeNode(lastNode);
            cache.remove(lastNode.key);
        }
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */