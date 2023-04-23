6
        Zigzag Conversion
        2022-12-28 13:50:28

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int charInSec = 2 * (numRows - 1);
        for (int currRow = 0; currRow < numRows; currRow++) {
            int index = currRow;
            while (index < n) {
                sb.append(s.charAt(index));
                if (currRow != 0 && currRow != numRows - 1) {
                    int charInBet = charInSec - 2 * currRow;
                    int secIndex = index + charInBet;
                    if (secIndex < n) {
                        sb.append(s.charAt(secIndex));
                    }
                }
                index += charInSec;
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
