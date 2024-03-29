
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (!map.containsKey(size)) {
                map.put(size, new ArrayList<>());
            }
            map.get(size).add(i);
            if (map.get(size).size() == size) {
                res.add(map.get(size));
                map.put(size, new ArrayList<>());
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
