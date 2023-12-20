2343
        Query Kth Smallest Trimmed Number
        2022-12-17 12:47:59

//leetcode submit region begin(Prohibit modification and deletion)
class Pair {
    int index;
    String value;

    public Pair(int index, String value) {
        this.index = index;
        this.value = value;
    }
}

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Pair[] copy = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = new Pair(i, nums[i]);
        }
        int d = nums[0].length();
        int[][] dp = new int[d][nums.length];
        int digitcount = 0;
        while (digitcount < d) {
            CountSort(copy, d - digitcount - 1);
            for (int i = 0; i < copy.length; i++)
                dp[digitcount][i] = copy[i].index;
            digitcount++;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = dp[queries[i][1] - 1][queries[i][0] - 1];
        }
        return result;
    }


    //frequency
    void CountSort(Pair[] nums, int digit) {

        int[] count = new int[10];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int value = nums[i].value.charAt(digit) - 48;
            count[value]++;
        }
        for (int i = 1; i <= 9; i++) {
            count[i] += count[i - 1];
        }
        Pair[] temp = new Pair[n];
        for (int i = n - 1; i >= 0; i--) {
            int value = nums[i].value.charAt(digit) - 48;
            temp[count[value] - 1] = nums[i];
            count[value]--;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
