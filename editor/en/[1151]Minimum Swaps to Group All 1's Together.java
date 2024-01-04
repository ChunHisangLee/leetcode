
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwaps(int[] data) {
        int totalOnes = Arrays.stream(data).sum();
        int left = 0;
        int maxOnes = 0;
        int currOnes = 0;

        for (int right = 0; right < data.length; right++) {
            currOnes += data[right];

            if (right - left + 1 > totalOnes) {
                currOnes -= data[left];
                left++;
            }

            maxOnes = Math.max(maxOnes, currOnes);
        }

        return totalOnes - maxOnes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
