
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int n = arrays.length;
        Map<Integer, Integer> arrMap = new HashMap<>();

        for (int[] arr : arrays) {
            for (int num : arr) {
                arrMap.put(num, arrMap.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> resultList = new ArrayList<>();

        for (int key : arrMap.keySet()) {
            if (arrMap.get(key) == n) {
                resultList.add(key);
            }
        }

        Collections.sort(resultList);

        return resultList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
