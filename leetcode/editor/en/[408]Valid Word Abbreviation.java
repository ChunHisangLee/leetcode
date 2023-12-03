
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] cWord = word.toCharArray();
        char[] cAbbr = abbr.toCharArray();
        int i = 0;
        int j = 0;

        while (i < cWord.length && j < cAbbr.length) {
            if (Character.isDigit(cAbbr[j])) {
                if (cAbbr[j] == '0') {
                    return false;
                }

                int num = 0;

                while (j < cAbbr.length && Character.isDigit(cAbbr[j])) {
                    num = num * 10 + (cAbbr[j] - '0');
                    j++;
                }

                i += num;
            } else {
                if (cWord[i] != cAbbr[j]) {
                    return false;
                }

                i++;
                j++;
            }
        }

        return i == cWord.length && j == cAbbr.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
