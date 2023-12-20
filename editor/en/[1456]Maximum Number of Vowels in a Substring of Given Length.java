1456
        TMaximum Number of Vowels in a Substring of Given Length
        2023-05-05 09:36:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVowels(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] arr = new int[n + 1];
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                count++;
            }
            arr[i + 1] = count;
        }
        for (int i = k; i < n + 1; i++) {
            max = Math.max(max, arr[i] - arr[i - k]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

