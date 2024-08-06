
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        for (String str : details) {
            int age = Integer.parseInt(str.substring(11, 13));

            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details)
                .parallel()
                .map(detail -> Integer.parseInt(detail.substring(11, 13)))
                .filter(age -> age > 60)
                .count();
    }
}
 */