2272
        Substring With Largest Variance
        2023-03-06 18:11:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestVariance(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.putIfAbsent(cur, new ArrayList<>());
            map.get(cur).add(i);
        }
        int max = 0;
        for (char c1 : map.keySet()) {
            for (char c2 : map.keySet()) {
                if (c1 != c2) {
                    int i = 0;
                    int j = 0;
                    int f = 0;
                    int g = Integer.MIN_VALUE;
                    List<Integer> map1 = map.get(c1);
                    List<Integer> map2 = map.get(c2);
                    while (i < map1.size() || j < map2.size()) {
                        if (j == map2.size() || (i < map1.size() && map1.get(i) < map2.get(j))) {
                            f = Math.max(f, 0) + 1;
                            g++;
                            i++;
                        } else {
                            g = Math.max(f, Math.max(g, 0)) - 1;
                            f = Math.max(f, 0) - 1;
                            j++;
                        }
                        max = Math.max(max, g);
                    }
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
