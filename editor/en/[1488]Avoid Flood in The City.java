
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            int rainDay = rains[i];
            if (rains[i] == 0) {
                set.add(i);
                ans[i] = 1;
            } else {
                if (!map.containsKey(rainDay))
                    map.put(rainDay, i);
                else {
                    int lastRain = map.get(rainDay);
                    Integer dryDay = set.higher(lastRain);
                    if (dryDay == null)
                        return new int[0];
                    else {
                        ans[dryDay] = rainDay;
                        set.remove(dryDay);
                        map.put(rainDay, i);
                    }
                }
                ans[i] = -1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
