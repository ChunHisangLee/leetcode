706
        Design HashMap
        2023-01-27 23:09:12

//leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap {
    int[] arr;

    public MyHashMap() {
        arr = new int[1000001];
    }

    public void put(int key, int value) {
        arr[key] = value + 1;
    }

    public int get(int key) {
        return arr[key] - 1;
    }

    public void remove(int key) {
        arr[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
