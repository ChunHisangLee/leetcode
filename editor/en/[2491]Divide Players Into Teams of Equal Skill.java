

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        long sumOfSkill = 0;

        for (int s : skill) {
            sumOfSkill += s;
        }

        long numerator = 2 * sumOfSkill;

        if (numerator % n != 0) {
            return -1;
        }

        long denominator = numerator / n;
        Arrays.sort(skill);
        long result = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            long pairSum = (long) skill[left] + (long) skill[right];

            if (pairSum != denominator) {
                return -1;
            }

            result += ((long) skill[left] * (long) skill[right]);
            left++;
            right--;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
