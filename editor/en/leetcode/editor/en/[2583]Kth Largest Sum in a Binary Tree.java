
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            if (minHeap.size() < k) {
                minHeap.offer(levelSum);
            } else if (levelSum > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(levelSum);
            }
        }

        if (minHeap.size() < k) {
            return -1;
        }

        return minHeap.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
