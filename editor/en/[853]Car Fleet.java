//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        Arrays.sort(cars, (a, b) -> a.position - b.position);
        int result = 0;
        double curr = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (cars[i].time > curr) {
                curr = cars[i].time;
                result++;
            }
        }

        return result;
    }

    class Car {
        int position;
        double time;

        Car(int p, double t) {
            position = p;
            time = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
