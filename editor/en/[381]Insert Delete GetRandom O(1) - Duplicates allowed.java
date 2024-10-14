
//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val);
        list.add(val);
        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size() - 1);
        return notPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        Iterator<Integer> it = map.get(val).iterator();
        int removeIdx = it.next();
        it.remove();
        int lastElement = list.get(list.size() - 1);
        int lastIdx = list.size() - 1;

        if (removeIdx != lastIdx) {
            list.set(removeIdx, lastElement);
            map.get(lastElement).remove(lastIdx);
            map.get(lastElement).add(removeIdx);
        }

        list.remove(lastIdx);

        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
