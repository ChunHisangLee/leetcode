
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int count_ = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                countL++;
            } else if (c == 'R') {
                countR++;
            } else {
                count_++;
            }
        }
        int position = countR - countL;
        return Math.abs(position) + count_;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
