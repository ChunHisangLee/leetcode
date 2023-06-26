
//leetcode submit region begin(Prohibit modification and deletion)
class TrafficLight {
    private AtomicBoolean greenOnRoadA;
    private ReentrantReadWriteLock greenSignalLock;

    public TrafficLight() {
        greenOnRoadA = new AtomicBoolean(true);
        greenSignalLock = new ReentrantReadWriteLock(true);
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) throws InterruptedException {
        greenSignalLock.readLock().lock();
        if (!isGreen(roadId)) {
            greenSignalLock.readLock().unlock();
            greenSignalLock.writeLock().lock();
            if (!isGreen(roadId)) {
                toggleGreen();
                turnGreen.run();
            }
            greenSignalLock.readLock().lock();
            greenSignalLock.writeLock().unlock();
        }
        crossCar.run();
        greenSignalLock.readLock().unlock();
    }

    private boolean isGreen(int roadId) {
        if (roadId == 1) {
            return greenOnRoadA.get();
        } else {
            return !greenOnRoadA.get();
        }
    }

    private void toggleGreen() {
        greenOnRoadA.set(!greenOnRoadA.get());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
