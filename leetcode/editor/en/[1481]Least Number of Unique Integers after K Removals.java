1481
        Least Number of Unique Integers after K Removals
        2022-12-10 21:31:11

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int val : map.values()) {
            list.add(val);
        }
        Collections.sort(list, Comparator.reverseOrder());
        while (k > 0) {
            int val = list.get(list.size() - 1);
            if (val <= k) {
                k -= val;
                list.remove(list.size() - 1);
            } else
                break;
        }
        return list.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
