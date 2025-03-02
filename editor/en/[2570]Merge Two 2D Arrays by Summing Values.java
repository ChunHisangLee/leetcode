// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    List<int[]> mergedList = new ArrayList<>();
    int i = 0;
    int j = 0;

    while (i < nums1.length && j < nums2.length) {
      int id1 = nums1[i][0];
      int val1 = nums1[i][1];
      int id2 = nums2[j][0];
      int val2 = nums2[j][1];

      if (id1 == id2) {
        mergedList.add(new int[] {id1, val1 + val2});
        i++;
        j++;
      } else if (id1 < id2) {
        mergedList.add(new int[] {id1, val1});
        i++;
      } else {
        mergedList.add(new int[] {id2, val2});
        j++;
      }
    }

    while (i < nums1.length) {
      mergedList.add(new int[] {nums1[i][0], nums1[i][1]});
      i++;
    }

    while (j < nums2.length) {
      mergedList.add(new int[] {nums2[j][0], nums2[j][1]});
      j++;
    }

    return mergedList.toArray(new int[mergedList.size()][]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
