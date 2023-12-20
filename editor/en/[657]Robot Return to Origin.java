657
        Robot Return to Origin
        2023-02-09 11:08:04

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeCircle(String moves) {
        int[] arr = new int[26];
        for (char c : moves.toCharArray()) {
            arr[c - 'A']++;
        }
        if (arr['U' - 'A'] == arr['D' - 'A'] && arr['L' - 'A'] == arr['R' - 'A']) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
