
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numString = new StringBuilder();

        for (char c : s.toCharArray()) {
            int num = c - 'a' + 1;
            numString.append(num);
        }

        String transformed = numString.toString();

        for (int i = 0; i < k; i++) {
            int sum = 0;

            for (char c : transformed.toCharArray()) {
                sum += c - '0';
            }

            transformed = Integer.toString(sum);
        }

        return Integer.parseInt(transformed);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
