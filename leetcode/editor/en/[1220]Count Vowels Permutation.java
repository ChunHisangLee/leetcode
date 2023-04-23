1220
        Count Vowels Permutation
        2023-02-27 10:09:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countVowelPermutation(int n) {
        int MOD = (int) 1e9 + 7;
        long aCount = 1;
        long eCount = 1;
        long iCount = 1;
        long oCount = 1;
        long uCount = 1;
        for (int i = 1; i < n; i++) {
            long aNew = (eCount + iCount + uCount) % MOD;
            long eNew = (aCount + iCount) % MOD;
            long iNew = (eCount + oCount) % MOD;
            long oNew = iCount % MOD;
            long uNew = (iCount + oCount) % MOD;
            aCount = aNew;
            eCount = eNew;
            iCount = iNew;
            oCount = oNew;
            uCount = uNew;
        }
        long res = 0;
        res = (aCount + eCount + iCount + oCount + uCount) % MOD;
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
