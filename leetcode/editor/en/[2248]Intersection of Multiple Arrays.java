2248
        Intersection of Multiple Arrays
        2022-11-27 16:28:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int[] arr : nums) {
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int n = nums.length;
        for (int key : map.keySet()) {
            if (map.get(key) == n) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
