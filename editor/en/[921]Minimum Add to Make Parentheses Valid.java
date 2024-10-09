
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int result = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;

                if (balance < 0) {
                    result++;
                    balance = 0;
                }
            }
        }

        return result + balance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
