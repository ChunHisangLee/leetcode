//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int maxHeight = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                list.add(i);
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
