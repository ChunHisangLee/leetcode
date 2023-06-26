
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            int lineLen = words[i].length();
            while (j < n && lineLen + words[j].length() + (j - i - 1) < maxWidth) {
                lineLen += words[j].length();
                j++;
            }
            int diff = maxWidth - lineLen;
            int numWords = j - i;
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            if (numWords == 1 || j >= n) {
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ");
                    sb.append(words[k]);
                }
                sb.append(" ".repeat(maxWidth - sb.length()));
            } else {
                int spaces = diff / (numWords - 1);
                int extraSpaces = diff % (numWords - 1);

                for (int k = i + 1; k < j; k++) {
                    int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
                    sb.append(" ".repeat(spacesToApply));
                    sb.append(words[k]);
                }
            }
            list.add(sb.toString());
            i = j;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
