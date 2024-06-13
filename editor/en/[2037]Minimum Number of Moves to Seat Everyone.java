
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        return IntStream.range(0, seats.length)
                .map(i -> Math.abs(students[i] - seats[i]))
                .sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        return IntStream.range(0, seats.length)
                .map(i -> Math.abs(students[i] - seats[i]))
                .sum();
    }
}

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int diff = 0;
        int n = seats.length;

        for (int i = 0; i < n; i++) {
            diff += Math.abs(students[i] - seats[i]);
        }

        return diff;
    }
}
 */