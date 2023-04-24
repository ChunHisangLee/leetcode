
//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {
    Map<Integer, Pair<Integer, Integer>> map;
    Map<Integer, LinkedHashSet<Integer>> freq;
    int min;
    int capacity;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freq = new HashMap<>();
        min = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Pair<Integer, Integer> pair = map.get(key);
        if (pair == null) {
            return -1;
        }
        int frequency = pair.getKey();
        Set<Integer> keys = freq.get(frequency);
        keys.remove(key);
        if (min == frequency && keys.isEmpty()) {
            min++;
        }
        final int value = pair.getValue();
        insert(key, frequency + 1, value);
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Pair<Integer, Integer> pair = map.get(key);
        if (pair != null) {
            map.put(key, new Pair<>(pair.getKey(), value));
            get(key);
            return;
        }
        if (capacity == map.size()) {
            Set<Integer> keys = freq.get(min);
            int keyToDelete = keys.iterator().next();
            map.remove(keyToDelete);
            keys.remove(keyToDelete);
        }
        min = 1;
        insert(key, 1, value);
    }

    public void insert(int key, int frequency, int value) {
        map.put(key, new Pair<>(frequency, value));
        freq.putIfAbsent(frequency, new LinkedHashSet<>());
        freq.get(frequency).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
