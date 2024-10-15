
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int last = index + 1;
            int count = words[index].length();

            while (last < n) {
                if (words[last].length() + count + 1 > maxWidth) {
                    break;
                }

                count += words[last].length() + 1;
                last++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last - index - 1;

            if (last == n || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }

                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;

                for (int i = index + 1; i < last; i++) {
                    for (int j = spaces; j > 0; j--) {
                        sb.append(" ");
                    }

                    if (r > 0) {
                        sb.append(" ");
                        r--;
                    }

                    sb.append(" ");
                    sb.append(words[i]);
                }
            }

            res.add(sb.toString());
            index = last;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
