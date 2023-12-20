
//leetcode submit region begin(Prohibit modification and deletion)
class ParkingSystem {
    int[] arr;
    int[] park;

    public ParkingSystem(int big, int medium, int small) {
        arr = new int[4];
        park = new int[4];
        park[1] = big;
        park[2] = medium;
        park[3] = small;
    }

    public boolean addCar(int carType) {
        arr[carType]++;
        return arr[carType] > park[carType] ? false : true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
//leetcode submit region end(Prohibit modification and deletion)
