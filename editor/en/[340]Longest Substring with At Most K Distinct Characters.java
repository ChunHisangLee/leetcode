//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] arr = new int[128];
        int left = 0;
        int res = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            arr[s.charAt(right)]++;

            if (arr[s.charAt(right)] == 1) {
                count++;
            }

            while (count > k) {
                if (arr[s.charAt(left)] == 1) {
                    count--;
                }

                arr[s.charAt(left)]--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
