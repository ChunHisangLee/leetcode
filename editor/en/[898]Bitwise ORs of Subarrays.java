
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        final Set<Integer> allOrValues = new HashSet<>();
        Set<Integer> prevOrSet = new HashSet<>();

        for (int num : arr) {
            Set<Integer> curOrSet = new HashSet<>();
            curOrSet.add(num);

            for (int prev : prevOrSet) {
                curOrSet.add(prev | num);
            }

            allOrValues.addAll(curOrSet);
            prevOrSet = curOrSet;
        }

        return allOrValues.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
