/**
 * <p>Convert a non-negative integer <code>num</code> to its English words representation.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = 123
 * <strong>Output:</strong> "One Hundred Twenty Three"
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = 12345
 * <strong>Output:</strong> "Twelve Thousand Three Hundred Forty Five"
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = 1234567
 * <strong>Output:</strong> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= num &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Math</li><li>String</li><li>Recursion</li></div></div><br><div><li>👍 2578</li><li>👎 5746</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return numberToWordsR(num).trim();
    }

    public String numberToWordsR(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 20) {
            switch (num) {
                case 0:
                    return "";
                case 1:
                    return "One ";
                case 2:
                    return "Two ";
                case 3:
                    return "Three ";
                case 4:
                    return "Four ";
                case 5:
                    return "Five ";
                case 6:
                    return "Six ";
                case 7:
                    return "Seven ";
                case 8:
                    return "Eight ";
                case 9:
                    return "Nine ";
                case 10:
                    return "Ten ";
                case 11:
                    return "Eleven ";
                case 12:
                    return "Twelve ";
                case 13:
                    return "Thirteen ";
                case 14:
                    return "Fourteen ";
                case 15:
                    return "Fifteen ";
                case 16:
                    return "Sixteen ";
                case 17:
                    return "Seventeen ";
                case 18:
                    return "Eighteen ";
                case 19:
                    return "Nineteen ";
            }
        } else if (num < 100) {
            int tens = num / 10;
            int ones = num % 10;
            switch (tens) {
                case 2:
                    sb.append("Twenty ");
                    break;
                case 3:
                    sb.append("Thirty ");
                    break;
                case 4:
                    sb.append("Forty ");
                    break;
                case 5:
                    sb.append("Fifty ");
                    break;
                case 6:
                    sb.append("Sixty ");
                    break;
                case 7:
                    sb.append("Seventy ");
                    break;
                case 8:
                    sb.append("Eighty ");
                    break;
                case 9:
                    sb.append("Ninety ");
                    break;
            }
            sb.append(numberToWordsR(ones));
        } else if (num < 1000) {
            sb.append(numberToWordsR(num / 100));
            sb.append("Hundred ");
            sb.append(numberToWordsR(num % 100));
        } else if (num < (int) 1e6) {
            sb.append(numberToWordsR(num / 1000));
            sb.append("Thousand ");
            sb.append(numberToWordsR(num % 1000));
        } else if (num < (int) 1e9) {
            sb.append(numberToWordsR(num / (int) 1e6));
            sb.append("Million ");
            sb.append(numberToWordsR(num % (int) 1e6));
        } else {
            sb.append(numberToWordsR(num / (int) 1e9));
            sb.append("Billion ");
            sb.append(numberToWordsR(num % (int) 1e9));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
