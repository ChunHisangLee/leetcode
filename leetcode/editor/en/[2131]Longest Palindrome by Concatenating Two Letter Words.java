
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        boolean isOdd = false;
        int res = 0;
        for (String key : map.keySet()) {
            int count = map.get(key);
            char[] c = key.toCharArray();
            if (c[0] == c[1]) {
                if (count % 2 == 0) {
                    res += count;
                } else {
                    res += count - 1;
                    isOdd = true;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c[1]).append(c[0]);
                String str = sb.toString();
                if (map.containsKey(str)) {
                    res += Math.min(map.get(str), count) * 2;
                    map.put(key, 0);
                }
            }
        }
        if (isOdd) {
            res++;
        }
        return res * 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
