
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        Map<Character, Integer> map = new HashMap<>();
        int[] prefixSum = new int[n];
        int result = 0;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + travel[i - 1];
        }

        for (int i = 0; i < n; i++) {
            result += garbage[i].length();

            for (char c : garbage[i].toCharArray()) {
                map.put(c, i);
            }
        }

        for (Integer index : map.values()) {
            result += prefixSum[index];
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
