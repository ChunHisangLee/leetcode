
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int count = 1;
        int index = 0;
        while (candies > count) {
            arr[index % num_people] += count;
            candies -= count;
            count++;
            index++;
        }

        arr[index % num_people] += candies;
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
