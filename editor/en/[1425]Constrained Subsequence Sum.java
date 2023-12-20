
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int result = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            nums[i] += !deque.isEmpty() ? deque.peek() : 0;
            result = Math.max(result, nums[i]);

            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }

            if (nums[i] > 0) {
                deque.offer(nums[i]);
            }

            if (i >= k && !deque.isEmpty() && deque.peek() == nums[i - k]) {
                deque.poll();
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dp = new int[n];
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && i - deque.peek() > k) {
                deque.poll();
            }

            dp[i] = (!deque.isEmpty() ? dp[deque.peek()] : 0) + nums[i];

            while (!deque.isEmpty() && dp[deque.peekLast()] < dp[i]) {
                deque.pollLast();
            }

            if (dp[i] > 0) {
                deque.offer(i);
            }
        }

        for (int num : dp) {
            result = Math.max(result, num);
        }

        return result;
    }
}
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int result = nums[0];

        heap.add(new int[]{nums[0], 0});

        for (int i = 1; i < nums.length; i++) {
            while (i - heap.peek()[1] > k) {
                heap.remove();
            }

            int curr = Math.max(0, heap.peek()[0]) + nums[i];
            result = Math.max(result, curr);
            heap.add(new int[]{curr, i});
        }

        return result;
    }
}
 */