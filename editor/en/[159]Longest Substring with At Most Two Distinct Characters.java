//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] arr = new int[256];
        int left = 0;
        int count = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (arr[rightChar] == 0) {
                count++;
            }

            arr[rightChar]++;

            while (count > 2) {
                char leftChar = s.charAt(left);
                arr[leftChar]--;

                if (arr[leftChar] == 0) {
                    count--;
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
