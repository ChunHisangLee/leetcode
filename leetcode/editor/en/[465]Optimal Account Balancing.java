
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = Integer.MAX_VALUE;

    public int minTransfers(int[][] transactions) {
        int[] debt = buildDept(transactions);
        return getTrans(debt, 0);
    }

    private int[] buildDept(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }

        int[] debt = new int[map.size()];
        int i = 0;
        for (int k : map.keySet()) {
            if (map.containsKey(k)) {
                debt[i++] = map.get(k);
            }
        }
        return debt;
    }

    private int getTrans(int[] debt, int index) {
        if (index == debt.length) {
            return 0;
        }
        if (debt[index] == 0) {
            return getTrans(debt, index + 1);
        }

        int d = debt[index];
        for (int i = index + 1; i < debt.length; i++) {
            if (d * debt[i] >= 0)
                continue;
            debt[i] += d;
            res = Math.min(res, 1 + getTrans(debt, index + 1));
            debt[i] -= d;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
