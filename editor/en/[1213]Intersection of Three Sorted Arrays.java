
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr3) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
