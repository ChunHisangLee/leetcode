//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int result = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            result++;
            right--;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
