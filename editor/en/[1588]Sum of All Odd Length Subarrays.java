//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int right = i;
            int count = 0;
            int temp = 0;
            while (right < len) {
                count++;
                temp += arr[right];
                if (count % 2 == 1)
                    sum += temp;
                right++;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
