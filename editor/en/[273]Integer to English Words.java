//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        StringBuilder words = new StringBuilder();

        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, helper(num % 1000).append(THOUSANDS[i]).append(" "));
            }

            num /= 1000;
            i++;
        }

        return words.toString().trim();
    }

    private StringBuilder helper(int num) {
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            return sb;
        } else if (num < 20) {
            return sb.append(LESS_THAN_20[num]).append(" ");
        } else if (num < 100) {
            return sb.append(TENS[num / 10]).append(" ").append(helper(num % 10));
        } else {
            return sb.append(LESS_THAN_20[num / 100]).append(" Hundred ").append(helper(num % 100));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
