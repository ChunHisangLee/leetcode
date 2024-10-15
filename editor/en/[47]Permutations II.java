
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        backtrack(new ArrayList<>(), nums.length);
        return res;
    }

    public void backtrack(List<Integer> list, int n) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                list.add(key);
                map.put(key, map.get(key) - 1);
                backtrack(list, n);
                list.remove(list.size() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
