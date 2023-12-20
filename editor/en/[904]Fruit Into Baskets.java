904
        Fruit Into maps
        2023-02-07 09:47:56

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap();
        int left = 0;
        int right;
        for (right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                    left++;
                }
            }
        }
        return right - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
