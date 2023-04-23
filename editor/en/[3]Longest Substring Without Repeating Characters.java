// 3
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int i = 0;
        int j = 0;
        int res = 0;
        while (j < s.length()) {
            if (arr[s.charAt(j)] == 0)
                arr[s.charAt(j++)] = 1;
            else if (arr[s.charAt(j)] == 1)
                arr[s.charAt(i++)] = 0;
            res = Math.max(res, j - i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        int[] arr = new int[256];
        for (int c = 0, i = 0, j = 0; j < len; j++) {
            c = s.charAt(j);
            i = Math.max(arr[c], i);
            res = Math.max(res, j - i + 1);
            arr[c] = j + 1;
        }
        return res;
    }
}
 */