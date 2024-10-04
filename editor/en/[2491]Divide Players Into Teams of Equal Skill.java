

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int sumOfSkill = 0;

        for (int s : skill) {
            sumOfSkill += s;
        }

        if (sumOfSkill % (n / 2) != 0) {
            return -1;
        }

        int denominator = sumOfSkill / (n / 2);
        Arrays.sort(skill);
        long result = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int pairSum = skill[left] + skill[right];

            if (pairSum != denominator) {
                return -1;
            }

            result += (long) skill[left] * (long) skill[right];
            left++;
            right--;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
