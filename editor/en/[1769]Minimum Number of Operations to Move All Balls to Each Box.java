
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int leftCount = 0;
        int leftDistance = 0;
        for(int i = 0; i < n; i++) {
            answer[i] += leftDistance;
            if(boxes.charAt(i) == '1') {
                leftCount += 1;
            }
            leftDistance += leftCount;
        }

        int rightCount = 0;
        int rightDistance = 0;
        for(int i = n - 1; i >= 0; i--) {
            answer[i] += rightDistance;
            if(boxes.charAt(i) == '1') {
                rightCount += 1;
            }
            rightDistance += rightCount;
        }

        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
