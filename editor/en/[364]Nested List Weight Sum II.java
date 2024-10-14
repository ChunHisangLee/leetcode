
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList, 1);
        return getWeightedSum(nestedList, maxDepth);
    }

    private int findMaxDepth(List<NestedInteger> nestedList, int depth) {
        int maxDepth = depth;

        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger() && !ni.getList().isEmpty()) {
                maxDepth = Math.max(maxDepth, findMaxDepth(ni.getList(), depth + 1));
            }
        }

        return maxDepth;
    }

    private int getWeightedSum(List<NestedInteger> nestedList, int maxDepth) {
        int sum = 0;

        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * maxDepth;
            } else if (!ni.getList().isEmpty()) {
                sum += getWeightedSum(ni.getList(), maxDepth - 1);
            }
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
