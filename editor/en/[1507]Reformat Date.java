
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        sb.append(date.substring(date.length() - 4)).append("-");
        String month = date.length() == 13 ? date.substring(5, 8) : date.substring(4, 7);

        switch (month) {
            case "Jan" -> sb.append("01-");
            case "Feb" -> sb.append("02-");
            case "Mar" -> sb.append("03-");
            case "Apr" -> sb.append("04-");
            case "May" -> sb.append("05-");
            case "Jun" -> sb.append("06-");
            case "Jul" -> sb.append("07-");
            case "Aug" -> sb.append("08-");
            case "Sep" -> sb.append("09-");
            case "Oct" -> sb.append("10-");
            case "Nov" -> sb.append("11-");
            case "Dec" -> sb.append("12-");
        }

        if (date.length() < 13) {
            sb.append("0");
            sb.append(date.substring(0, 1));
        } else {
            sb.append(date.substring(0, 2));
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
