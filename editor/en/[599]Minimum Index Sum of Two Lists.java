599
        Minimum Index Sum of Two Lists
        2023-01-28 12:50:59

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < list2.length && i <= min; i++) {
            if (map.containsKey(list2[i])) {
                sum = map.get(list2[i]) + i;
                if (sum < min) {
                    list.clear();
                    list.add(list2[i]);
                    min = sum;
                } else if (sum == min) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
