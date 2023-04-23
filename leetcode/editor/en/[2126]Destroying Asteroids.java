2126
        Destroying Asteroids
        2022-12-10 14:32:57

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for (int num : asteroids) {
            if (num > currMass)
                return false;
            currMass += num;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
