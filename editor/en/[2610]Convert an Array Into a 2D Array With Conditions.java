
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!map.isEmpty()) {
            List<Integer> list = new ArrayList<>(map.keySet());
            result.add(list);

            for (int key : list) {
                map.put(key, map.get(key) - 1);

                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
