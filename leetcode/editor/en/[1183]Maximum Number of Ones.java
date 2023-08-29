
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int n = sideLength * sideLength;
        int[] arr = new int[n];
        for (int i = 0; i < height; i++) {
            int row = i % sideLength;
            for (int j = 0; j < width; j++) {
                int col = j % sideLength;
                arr[(row * sideLength) + col]++;
            }
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < maxOnes; i++) {
            res += arr[n - 1 - i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
