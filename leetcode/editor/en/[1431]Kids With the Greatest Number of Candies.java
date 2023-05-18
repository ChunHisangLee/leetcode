
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int num : candies) {
            max = Math.max(max, num);
        }
        List<Boolean> list = new ArrayList<>();
        max -= extraCandies;
        for (int num : candies) {
            list.add(num >= max);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
