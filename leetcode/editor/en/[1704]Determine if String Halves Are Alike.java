1704
        Determine if String Halves Are Alike
        2022-12-01 09:45:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String vowels = "aeiouAEIOU";
        String first = s.substring(0, len / 2);
        String sceond = s.substring(len / 2, len);
        int countFirst = 0;
        for (char c : first.toCharArray()) {
            if (vowels.indexOf(c) != -1)
                countFirst++;
        }
        int countSecond = 0;
        for (char c : sceond.toCharArray()) {
            if (vowels.indexOf(c) != -1)
                countSecond++;
        }
        return countFirst == countSecond;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
