//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];
        for (int c : citations) {
            arr[Math.min(c, n)]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += arr[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= count + 1) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}
 */