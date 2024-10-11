
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();

        for (String word : sentence) {
            sb.append(word).append(" ");
        }

        String s = sb.toString();
        int n = s.length();
        int start = 0;

        for (int i = 0; i < rows; i++) {
            start += cols;

            if (s.charAt(start % n) == ' ') {
                start += 1;
            } else {
                while (start > 0 && s.charAt((start - 1) % n) != ' ') {
                    start--;
                }
            }
        }

        return start / n;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
