
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
