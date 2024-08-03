//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        Map<Integer, Integer> arrMap = new HashMap<>();
        IntStream.of(target).forEach(num -> targetMap.merge(num, 1, Integer::sum));
        IntStream.of(arr).forEach(num -> arrMap.merge(num, 1, Integer::sum));
        return targetMap.equals(arrMap);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        Map<Integer, Integer> arrMap = new HashMap<>();

        for (int num : target) {
            targetMap.merge(num, 1, Integer::sum);
        }

        for (int num : arr) {
            arrMap.merge(num, 1, Integer::sum);
        }

        return targetMap.equals(arrMap);
    }
}
 */
