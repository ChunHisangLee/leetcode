151
        Reverse Words in a String
        2023-01-23 20:57:26

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
