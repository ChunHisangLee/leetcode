1710
        Maximum Units on a Truck
        2022-12-11 01:29:31

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            int box = Math.min(truckSize, boxType[0]);
            res += box * boxType[1];
            truckSize -= box;
            if (truckSize == 0)
                break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
