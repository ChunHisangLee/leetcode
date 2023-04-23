340
        Longest Substring with At Most K Distinct Characters
        2023-01-31 10:50:40

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        if (k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        while (right < n) {
            map.put(ch[right], right);
            right++;
            if (map.size() == k + 1) {
                int index = Collections.min(map.values());
                map.remove(ch[index]);
                left = index + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
