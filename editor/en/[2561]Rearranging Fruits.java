
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int a : basket1) count.merge(a, 1, Integer::sum);
        for (int a : basket2) count.merge(a, -1, Integer::sum);

        List<Integer> fromA = new ArrayList<>();
        List<Integer> fromB = new ArrayList<>();
        int small = Integer.MAX_VALUE;

        for (int x : count.keySet()) {
            int c = count.get(x);
            if (c % 2 != 0) return -1;
            small = Math.min(small, x);
            int times = Math.abs(c) / 2;
            if (c > 0) {
                for (int i = 0; i < times; i++) fromA.add(x);
            } else if (c < 0) {
                for (int i = 0; i < times; i++) fromB.add(x);
            }
        }

        // sort fromA ascending, fromB descending
        Collections.sort(fromA);
        fromB.sort(Collections.reverseOrder());

        long cost = 0;
        for (int i = 0; i < fromA.size(); i++) {
            int a = fromA.get(i);
            int b = fromB.get(i);
            cost += Math.min(Math.min(a, b), 2 * small);
        }

        return cost;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
