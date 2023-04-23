

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
        int n = reward1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            sum += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i++) {
            sum += diff[n - 1 - i];
        }
        return sum;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
 */
