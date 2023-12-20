
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int partitionString(String s) {
        int[] arr = new int[26];
        int count = 1;
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] > 0) {
                count++;
                Arrays.fill(arr, 0);
            }
            arr[c - 'a']++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)