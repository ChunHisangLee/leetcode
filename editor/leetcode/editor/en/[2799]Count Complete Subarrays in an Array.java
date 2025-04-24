// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countCompleteSubarrays(int[] nums) {
    int n = nums.length;
    boolean[] seen = new boolean[2001];
    int d = 0;

    for (int num : nums) {
      if (!seen[num]) {
        seen[num] = true;
        d++;
      }
    }

    int[] freq = new int[2001];
    int distinctCount = 0;
    long answer = 0;
    int right = 0;

    for (int left = 0; left < n; left++) {
      while (right < n && distinctCount < d) {
        if (freq[nums[right]] == 0) {
          distinctCount++;
        }
        freq[nums[right]]++;
        right++;
      }

      if (distinctCount == d) {
        answer += (n - (right - 1));
      } else {
        break;
      }

      freq[nums[left]]--;

      if (freq[nums[left]] == 0) {
        distinctCount--;
      }
    }

    return (int) answer;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
