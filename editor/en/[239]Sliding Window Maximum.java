239
        Sliding Window Maximum
        2022-11-30 09:57:38

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            return nums;
        }
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int[] arr = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            arr[i] = Math.max(left[i + k - 1], right[i]);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
/**
    将链表 切分成大小为 k 的 chunk
    然后 left 记录在 chunk 内从左往右的最大值,
         right 记录 chunk 内从右往左的最大值
    滑动窗口只需要找 right[i] 和 left[i + k - 1]的最大值

            1  3  -1  * -3  5  3  *  6  7
    left    1  3  3     -3  5  5     6  7
    right   3  3  -1     5  5  3     7  7

    TC: O(N)    SC: O(N) 16ms

*/
/*
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N - k + 1];
        int[] left = new int[N];
        int[] right = new int[N];
        for (int i = 0; i < N; i += k) {
            int max = Integer.MIN_VALUE;
            int rightBound = Math.min(i + k - 1, N - 1);
            // from left to right -->
            for (int j = i; j <= rightBound; j++) {
                if (nums[j] > max)
                    max = nums[j];
                left[j] = max;
            }
            // from right to left <--
            max = Integer.MIN_VALUE;
            for (int j = rightBound; j >= i; j--) {
                if (nums[j] > max)
                    max = nums[j];
                right[j] = max;
            }
        }
        for (int i = 0; i < N - k + 1; i++) {
            int j = i + k - 1;
            res[i] = Math.max(right[i], left[j]);
        }
        return res;
    }
}

/**
 维护一个 单调递减 的 Monotonic Queue, 尾进头出
 TC: O(n)    SC: O(k)
 36ms
 */
/*
class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N  = nums.length;
        int[] res = new int[N - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            // 保证窗口内 从大到小, 如果前面的数小则需要一次弹出, 直到满足要求
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 判断队首的值是否在 k 的滑动窗口内
            if (queue.peekFirst() <= i - k) {
                queue.poll();
            }
            // 当增长到窗口长度为k时 保存当前窗口中最大值
            if (i + 1 - k >= 0) {
                res[i + 1 - k] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
 */