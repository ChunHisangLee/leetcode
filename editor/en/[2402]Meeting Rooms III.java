2402
        Meeting Rooms III
        2022-12-19 13:47:43

/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] count = new int[n];
        long[] room = new long[n];
        for (int i = 0; i < meetings.length; i++) {
            int meetingStart = meetings[i][0];
            int meetingEnd = meetings[i][1];
            int nextRoom = -1;
            long sooner = Long.MAX_VALUE;
            for (int j = 0; j < room.length; j++) {
                if (room[j] <= meetingStart) {
                    nextRoom = j;
                    break;
                }
                if (room[j] < sooner) {
                    nextRoom = j;
                    sooner = room[j];
                }
            }
            count[nextRoom]++;
            room[nextRoom] = Math.max(meetingEnd, meetingEnd - meetingStart + room[nextRoom]);
        }
        int max = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > count[max]) {
                max = i;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
