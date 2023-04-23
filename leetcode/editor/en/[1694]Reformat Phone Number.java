
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : number.toCharArray()) {
            if (c == ' ' || c == '-') {
                continue;
            }
            if (count == 3) {
                count = 0;
                sb.append("-");
            }
            count++;
            sb.append(c);
        }
        if (count == 1) {
            int n = sb.length();
            char c = sb.charAt(n - 3);
            sb.setCharAt(n - 2, c);
            sb.setCharAt(n - 3, '-');
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
public String reformatNumber(String number) {
    return number.replaceAll("\\D", "").replaceAll("...?(?=..)", "$0-");
}
 */