
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (citations[mid] == n - mid) {
                return citations[mid];
            } else if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int hIndex(int[] citations) {
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= count + 1) {
                count++;
            }else{
                return count;
            }
        }
        return count;
    }
}
 */