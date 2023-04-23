557
        Reverse Words in a String III
        2023-01-23 20:57:27

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        String[] words = s.split("\s+");
        for (String word : words) {
            char[] ch = word.toCharArray();
            for (int i = ch.length - 1; i >= 0; i--) {
                sb.append(ch[i]);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
