//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> list, int level) {
        int sum = 0;

        for (NestedInteger item : list) {
            if (item.isInteger()) {
                sum += item.getInteger() * level;
            } else {
                sum += dfs(item.getList(), level + 1);
            }
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Deque<NestedInteger> dq = new ArrayDeque<>();
        dq.addAll(nestedList);
        int level = 1;
        int sum = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = dq.poll();
                if (curr.isInteger()) {
                    sum += curr.getInteger() * level;
                } else {
                    dq.addAll(curr.getList());
                }
            }
            level++;
        }
        return sum;
    }
}
 */
