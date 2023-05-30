705
        Design HashSet
        2023-01-27 23:09:10

//leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {

    int[] arr;

    public MyHashSet() {
        int n = (int) 1e6 + 1;
        arr = new int[n];
    }

    public void add(int key) {
        arr[key] = 1;
    }

    public void remove(int key) {
        arr[key] = 0;
    }

    public boolean contains(int key) {
        return arr[key] == 1 ? true : false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
