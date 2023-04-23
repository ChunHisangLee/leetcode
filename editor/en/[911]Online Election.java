//leetcode submit region begin(Prohibit modification and deletion)
class TopVotedCandidate {

    int[] winner;
    int[] times1;

    public TopVotedCandidate(int[] persons, int[] times) {
        Map<Integer, Integer> count = new HashMap<>();
        int length = persons.length;
        winner = new int[length];
        int lead = 0;
        for (int i = 0; i < length; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (count.get(persons[i]) >= count.get(lead)) lead = persons[i];
            winner[i] = lead;
        }
        times1 = times;
    }

    public int q(int t) {
        int binaryIndex = Arrays.binarySearch(times1, t);
        int result = binaryIndex >= 0 ? binaryIndex : -binaryIndex - 2;
        return winner[result];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//leetcode submit region end(Prohibit modification and deletion)
