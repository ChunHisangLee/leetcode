89
        Gray Code
        2023-01-24 23:23:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
        // 0: [0]
        // 1: [0,1]
        // 2: [0,1,3,2]
        // 3: [0,1,3,2,6,7,5,4]
        // 4: [0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8]
        int edge = 1 << n;// (1 << n) == 2 ** n
        Integer[] res = new Integer[edge];
        res[0] = 0;
        int length = 1;// is the length of the previous block
        int i;
        int j = 1;
        while (j != edge) {
            length = j;
            for (i = length - 1; i >= 0; i--) {
                res[j] = res[i] | length;// ans[i] | lngth  == ans[i] + lngth
                j++;
            }
        }
        return Arrays.asList(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
