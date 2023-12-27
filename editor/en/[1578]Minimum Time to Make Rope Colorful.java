//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;

        for (int i = 1; i < neededTime.length; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i)) {
                if (neededTime[i - 1] <= neededTime[i]) {
                    totalTime += neededTime[i - 1];
                } else {
                    totalTime += neededTime[i];
                    neededTime[i] = neededTime[i - 1];
                }
            }
        }

        return totalTime;
    }
}
//leetcode submit region end(Prohibit modification and deletion
/*
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int left = 0;
        int right = 1;
        int sum = 0;

        while (right < n) {
            int tempSum = 0;

            if (colors.charAt(right) == colors.charAt(left)) {
                int max = neededTime[left];

                while (right < n && colors.charAt(right) == colors.charAt(left)) {
                    if (max < neededTime[right]) {
                        tempSum += max;
                        max = neededTime[right];
                    } else {
                        tempSum += neededTime[right];
                    }

                    right++;
                }
            }

            sum += tempSum;
            left = right;
            right++;
        }

        return sum;
    }
}
 */