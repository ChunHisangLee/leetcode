//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);

        int left = 0;
        int right = warehouse.length - 1;
        int count = 0;
        int index = boxes.length - 1;

        while (left <= right && index >= 0) {
            if (boxes[index] <= warehouse[left]) {
                count++;
                left++;
            } else if (boxes[index] <= warehouse[right]) {
                count++;
                right--;
            }

            index--;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
