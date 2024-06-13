
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(students);
        Arrays.sort(seats);
        return IntStream.range(0, seats.length)
                .mapToObj(i -> Math.abs(students[i] - seats[i]))
                .reduce(0, (a, b) -> a + b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        return IntStream.range(0, seats.length)
                .mapToObj(i -> Math.abs(students[i] - seats[i]))
                .reduce(0, (a, b) -> a + b);
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