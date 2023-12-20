380
        Insert Delete GetRandom O(1)
        2023-01-12 18:33:02

//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {
    Set<Integer> set;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        set.remove(val);
        list.remove(new Integer(val));
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(set.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
