881
        Boats to Save People
        2022-12-10 21:58:22

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int res = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            res++;
            right--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
