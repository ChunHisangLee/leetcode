340
        Longest Substring with At Most K Distinct Characters
        2023-01-31 10:50:40

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] arr = new int[128];
        char[] c = s.toCharArray();
        int left = 0;
        int res = 0;
        int count = 0;
        for (int right = 0; right < c.length; right++) {
            arr[c[right]]++;
            if (arr[c[right]] == 1) {
                count++;
            }
            while (count > k) {
                if (arr[c[left]] == 1) {
                    count--;
                }
                arr[c[left]]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
