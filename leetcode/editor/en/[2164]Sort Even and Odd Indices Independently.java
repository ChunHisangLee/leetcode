
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                arr[i] = even.poll();
            } else {
                arr[i] = odd.poll();
            }
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
