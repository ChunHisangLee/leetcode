
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        int totalSwaps = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            totalSwaps += minSwapsToSort(currentLevel);
        }

        return totalSwaps;
    }
    private int minSwapsToSort(List<Integer> list) {
        int n = list.size();

        if (n <= 1) {
            return 0;
        }

        int[] sortedArr = new int[n];

        for (int i = 0; i < n; i++) {
            sortedArr[i] = list.get(i);
        }

        Arrays.sort(sortedArr);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.binarySearch(sortedArr, list.get(i));
        }

        boolean[] visited = new boolean[n];
        int cycles = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycles++;
                int j = i;

                while (!visited[j]) {
                    visited[j] = true;
                    j = arr[j];
                }
            }
        }

        return n - cycles;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
