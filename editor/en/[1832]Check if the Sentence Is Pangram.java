1832
        Check if the Sentence Is Pangram
        2022-11-26 00:37:52

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfPangram(String sentence) {
        char[] chars = sentence.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch : chars) {
            set.add(ch);
        }
        return set.size() == 26 ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
