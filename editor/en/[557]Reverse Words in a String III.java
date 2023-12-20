557
Reverse Words in a String III
        2023-01-23 20:57:27

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            result.append(sb.reverse().toString()).append(" ");
        }

        return result.toString().trim();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = 0;

        while (left < c.length) {
            while (right < c.length && c[right] != ' ') {
                right++;
            }

            reverseWord(left, right - 1, c);
            left = right + 1;
            right = left;
        }

        return String.valueOf(c);
    }

    private void reverseWord(int left, int right, char[] c) {
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }
}
 */