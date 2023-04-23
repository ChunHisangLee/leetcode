import java.util.HashMap;

// 1832
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26)
            return false;
        for (int i = 0; i < 26; i++) {
            if (sentence.indexOf((char) i + 97) < 0)
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
