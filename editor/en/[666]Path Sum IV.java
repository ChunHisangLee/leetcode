//leetcode submit region begin(Prohibit modification and deletion)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int pathSum(int[] nums) {
        Map<Integer, Integer> treeMap = new HashMap<>();

        for (int num : nums) {
            int depth = num / 100;
            int position = (num / 10) % 10;
            int value = num % 10;
            int key = depth * 10 + position;
            treeMap.put(key, value);
        }

        return dfs(treeMap, nums[0] / 100, (nums[0] / 10) % 10, 0);
    }

    private int dfs(Map<Integer, Integer> treeMap, int depth, int position, int currentSum) {
        int key = depth * 10 + position;
        currentSum += treeMap.get(key);
        int leftChildKey = (depth + 1) * 10 + (2 * position - 1);
        int rightChildKey = (depth + 1) * 10 + (2 * position);
        boolean hasLeft = treeMap.containsKey(leftChildKey);
        boolean hasRight = treeMap.containsKey(rightChildKey);

        if (!hasLeft && !hasRight) {
            return currentSum;
        }

        int totalSum = 0;

        if (hasLeft) {
            totalSum += dfs(treeMap, depth + 1, 2 * position - 1, currentSum);
        }

        if (hasRight) {
            totalSum += dfs(treeMap, depth + 1, 2 * position, currentSum);
        }

        return totalSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
