
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            int currMin = list.get(0);
            int currMax = list.get(list.size() - 1);
            result = Math.max(result, Math.max(Math.abs(currMax - min), Math.abs(max - currMin)));
            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
