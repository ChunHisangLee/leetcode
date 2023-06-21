
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSubstrings(String s) {
        char[] c = s.toCharArray();
        return getCount(c, 3) - getCount(c, 2);
    }

    private int getCount(char[] c, int k) {
        int n = c.length;
        int[] arr = new int[3];
        int count = 0;
        int res = 0;
        for (int left = 0, right = 0; right < n; right++) {
            if (arr[c[right] - 'a'] == 0) {
                count++;
            }
            arr[c[right] - 'a']++;
            while (count > k) {
                arr[c[left] - 'a']--;
                if (arr[c[left] - 'a'] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
