
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < variables.length; i++) {
            int[] var = variables[i];

            if (calculateModulus(var[0], var[1], var[2], var[3]) == target) {
                list.add(i);
            }
        }

        return list;
    }

    private int calculateModulus(int a, int b, int c, int m) {
        int firstModulus = modularExponentiation(a, b, 10);
        int result = modularExponentiation(firstModulus, c, m);
        return result;
    }

    private int modularExponentiation(int base, int exponent, int modulus) {
        if (modulus == 1) {
            return 0;
        }

        int result = 1;
        base = base % modulus;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }

            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
