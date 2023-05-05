28
        Find the Index of the First Occurrence in a String
        2023-03-03 14:07:24

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();
        Deque<Integer> temp = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!dq2.isEmpty() && nums[dq2.peek()] < num) {
                arr[dq2.pop()] = num;
            }
            while (!dq1.isEmpty() && nums[dq1.peek()] < num) {
                temp.push(dq1.pop());
            }
            while (!temp.isEmpty()) {
                dq2.push(temp.pop());
            }
            dq1.push(i);
        }
        return arr;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
 */