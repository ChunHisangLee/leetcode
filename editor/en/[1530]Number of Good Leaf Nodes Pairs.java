
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPairs(TreeNode root, int distance) {
        AtomicInteger result = new AtomicInteger(0);
        dfs(root, distance, result);
        return result.get();
    }

    private List<Integer> dfs(TreeNode node, int distance, AtomicInteger result) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.left == null && node.right == null) {
            List<Integer> leafDistances = new ArrayList<>();
            leafDistances.add(0);
            return leafDistances;
        }

        List<Integer> leftDistances = dfs(node.left, distance, result);
        List<Integer> rightDistances = dfs(node.right, distance, result);

        for (int leftDist : leftDistances) {
            for (int rightDist : rightDistances) {
                if (leftDist + rightDist + 2 <= distance) {
                    result.incrementAndGet();
                }
            }
        }

        List<Integer> currentDistances = new ArrayList<>();

        for (int leftDist : leftDistances) {
            if (leftDist + 1 < distance) {
                currentDistances.add(leftDist + 1);
            }
        }

        for (int rightDist : rightDistances) {
            if (rightDist + 1 < distance) {
                currentDistances.add(rightDist + 1);
            }
        }

        return currentDistances;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    int result = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }

    private int[] dfs(TreeNode root, int distance) {
        if (root == null) {
            return new int[distance + 1];
        }

        if (root.left == null && root.right == null) {
            int res[] = new int[distance + 1];
            res[1]++;
            return res;
        }

        int[] left = dfs(root.left, distance);
        int[] right = dfs(root.right, distance);

        for (int l = 1; l < left.length; l++) {
            for (int r = distance - 1; r >= 0; r--) {
                if (l + r <= distance)
                    result += left[l] * right[r];
            }
        }

        int res[] = new int[distance + 1];

        for (int i = res.length - 2; i >= 1; i--) {
            res[i + 1] = left[i] + right[i];
        }

        return res;
    }
}
 */