2351
        First Letter to Appear Twice
        2022-11-26 00:22:07

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (set.contains(ch[i]))
                return ch[i];
            set.add(ch[i]);
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
