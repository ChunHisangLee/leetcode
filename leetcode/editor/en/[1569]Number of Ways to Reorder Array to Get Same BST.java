/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)

import java.math.BigInteger;

class Solution {
    private long MODULUS_LONG = (long) 1e9 + 7;
    private BigInteger MODULUS_BIG = BigInteger.valueOf(MODULUS_LONG);
    public int numOfWays(int[] nums) {
        Bst bst = new Bst(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            bst.add(nums[i]);
        }
        return countWays(bst) - 1;
    }

    private int countWays(Bst bst) {
        if (bst == null) {
            return 1;
        } else if (bst.left == null) {
            return countWays(bst.right);
        } else if (bst.right == null) {
            return countWays(bst.left);
        } else {
            long a = countWays(bst.left);
            long b = countWays(bst.right);
            long c = nCr(bst.size - 1, bst.left.size);
            return (int) ((a * b) % MODULUS_LONG * c % MODULUS_LONG);
        }
    }

    private int nCr(int n, int r) {
        if (n < 2 * r) {
            return nCr(n, n - r);
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < r; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));
            result = result.divide(BigInteger.valueOf(i + 1));
        }
        return result.mod(MODULUS_BIG).intValue();
    }

    private class Bst {
        private int rootVal;
        private Bst left;
        private Bst right;
        private int size;
        public Bst(int val) {
            this.rootVal = val;
            this.size = 1;
        }
        public void add(int val) {
            if (val < this.rootVal) {
                if (this.left == null) {
                    this.left = new Bst(val);
                } else {
                    this.left.add(val);
                }
            } else {
                if (this.right == null) {
                    this.right = new Bst(val);
                } else {
                    this.right.add(val);
                }
            }
            this.size++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
