
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int countF = 0;
        int countT = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        char[] c = answerKey.toCharArray();
        while (right < c.length) {
            if (c[right] == 'F') {
                countF++;
            } else {
                countT++;
            }
            while (Math.min(countT, countF) > k) {
                if (c[left] == 'F') {
                    countF--;
                } else {
                    countT--;
                }
                left++;
            }
            res = Math.max(res, countF + countT);
            right++;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
