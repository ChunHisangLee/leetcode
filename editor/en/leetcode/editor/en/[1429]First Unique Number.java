
//leetcode submit region begin(Prohibit modification and deletion)
class FirstUnique {
    private Map<Integer, Integer> countMap;
    private Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        countMap = new HashMap<>();
        queue = new LinkedList<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && countMap.get(queue.peek()) > 1) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            return -1;
        }

        return queue.peek();
    }

    public void add(int value) {
        countMap.put(value, countMap.getOrDefault(value, 0) + 1);

        if (countMap.get(value) == 1) {
            queue.offer(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
//leetcode submit region end(Prohibit modification and deletion)
