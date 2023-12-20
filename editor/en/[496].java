496
        Next Greater Element I
        2023-03-03 16:06:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums1.length;
        for (int num : nums2) {
            while (!dq.isEmpty() && dq.peek() < num) {
                map.put(dq.pop(), num);
            }
            dq.push(num);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = map.getOrDefault(nums1[i], -1);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
