
//leetcode submit region begin(Prohibit modification and deletion)
class TrafficLight {
    int
    private int light;

    public TrafficLight() {
        light = 1;
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) throws InterruptedException {
        synchronized (this) {
            if (light != roadId) {
                turnGreen.run();
                light = roadId;
            }

            crossCar.run();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
