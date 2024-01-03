
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int total = 0;

        for (String row : bank) {
            int curr = getCount(row);

            if (curr == 0) {
                continue;
            }

            total += curr * prev;
            prev = curr;
        }

        return total;
    }

    private int getCount(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            count += c - '0';
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
