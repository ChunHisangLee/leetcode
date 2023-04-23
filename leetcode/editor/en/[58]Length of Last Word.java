58
        Length of Last Word
        2022-11-24 09:22:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        int right = s.length();
        int count = 0;
        while (right > 0) {
            right--;
            if (s.charAt(right) != ' ')
                count++;
            else if (count > 0)
                return count;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
