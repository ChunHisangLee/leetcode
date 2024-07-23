
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    int compare = map.get(a).compareTo(map.get(b));
                    return compare == 0 ? b.compareTo(a) : compare;
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
