// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minOperations(int[] nums, int k) {
    Map<Integer, Integer> map = new TreeMap<>();

    for (int num : nums) {
      map.merge(num, 1, Integer::sum);

      for (int key : map.keySet()) {
        if(key<k){
          return -1;
        }
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
