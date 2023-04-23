
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> list = new ArrayList<>();
        max -= extraCandies;
        for (int candy : candies) {
            list.add(candy >= max);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
