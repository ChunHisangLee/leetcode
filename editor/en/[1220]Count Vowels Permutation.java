1220
        Count Vowels Permutation
        2023-02-27 10:09:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countVowelPermutation(int n) {
        final int MOD = (int) 1e9 + 7;
        long aCount = 1, eCount = 1, iCount = 1, oCount = 1, uCount = 1;

        for (int i = 1; i < n; i++) {
            long prevA = aCount, prevE = eCount, prevI = iCount, prevO = oCount, prevU = uCount;

            aCount = (prevE + prevI + prevU) % MOD;
            eCount = (prevA + prevI) % MOD;
            iCount = (prevE + prevO) % MOD;
            oCount = prevI % MOD;
            uCount = (prevI + prevO) % MOD;
        }

        return (int) ((aCount + eCount + iCount + oCount + uCount) % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
