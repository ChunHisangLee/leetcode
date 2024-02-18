//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] count = new int[n];
        long[] room = new long[n];

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            int nextRoom = getAvailableRoom(start, room);
            count[nextRoom]++;
            room[nextRoom] = Math.max(end, end - start + room[nextRoom]);
        }

        return getMostBookedRoom(count);
    }

    private int getAvailableRoom(int start, long[] room) {
        long earliest = Long.MAX_VALUE;
        int nextAvailable = -1;

        for (int j = 0; j < room.length; j++) {
            if (room[j] <= start) {
                nextAvailable = j;
                break;
            }

            if (room[j] < earliest) {
                nextAvailable = j;
                earliest = room[j];
            }
        }

        return nextAvailable;
    }

    private int getMostBookedRoom(int[] count) {
        int maxBooked = 0;

        for (int i = 1; i < count.length; i++) {
            if (count[i] > count[maxBooked]) {
                maxBooked = i;
            }
        }

        return maxBooked;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
