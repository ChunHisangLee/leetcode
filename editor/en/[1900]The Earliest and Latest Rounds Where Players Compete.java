
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    private final Map<Long, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        if (firstPlayer > secondPlayer) {
            int tmp = firstPlayer;
            firstPlayer = secondPlayer;
            secondPlayer = tmp;
        }
        return dfs(n, firstPlayer, secondPlayer);
    }

    private int[] dfs(int k, int a, int b) {
        if (a + b == k + 1) {
            return new int[]{1, 1};
        }

        long key = pack(k, a, b);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int p = k / 2;
        int middle = (k % 2 == 1) ? (p + 1) : -1;

        int forcedBits = 0;
        int maskNeed = 0;

        for (int j = 0; j < p; ++j) {
            int front = j + 1;
            int back = k - j;

            if (front == a || back == a) {
                maskNeed |= (1 << j);
                if (back == a) {
                    forcedBits |= (1 << j);
                }
            } else if (front == b || back == b) {
                maskNeed |= (1 << j);
                if (back == b) {
                    forcedBits |= (1 << j);
                }
            }
        }

        int earliest = Integer.MAX_VALUE;
        int latest = Integer.MIN_VALUE;

        int total = 1 << p;
        Set<Long> nextStates = new HashSet<>();

        Outer:
        for (int bits = 0; bits < total; ++bits) {
            if ((bits & maskNeed) != forcedBits) {
                continue;
            }

            List<Integer> winners = new ArrayList<>(p + 1);

            for (int j = 0; j < p; ++j) {
                int front = j + 1;
                int back = k - j;

                int winner;
                if (front == a || back == a) {
                    winner = a;
                } else if (front == b || back == b) {
                    winner = b;
                } else {
                    winner = ((bits & (1 << j)) == 0) ? front : back;
                }
                winners.add(winner);
            }
            if (middle != -1) {
                winners.add(middle);
            }

            Collections.sort(winners);

            int kNext = winners.size();
            int aNext = binarySearch(winners, a) + 1;
            int bNext = binarySearch(winners, b) + 1;
            if (aNext > bNext) {
                int tmp = aNext;
                aNext = bNext;
                bNext = tmp;
            }

            nextStates.add(pack(kNext, aNext, bNext));
        }

        for (long st : nextStates) {
            int kNext = (int) (st >> 20);
            int aNext = (int) ((st >> 10) & 0x3FF);
            int bNext = (int) (st & 0x3FF);

            int[] sub = dfs(kNext, aNext, bNext);
            earliest = Math.min(earliest, sub[0] + 1);
            latest = Math.max(latest, sub[1] + 1);
        }

        int[] res = new int[]{earliest, latest};
        memo.put(key, res);
        return res;
    }


    private static long pack(int k, int a, int b) {
        // k、a、b 均 ≤ 28，只需各 5 bit；這裡用 <<20 / <<10 方便
        return ((long) k << 20) | ((long) a << 10) | b;
    }

    private static int binarySearch(List<Integer> list, int key) {
        int idx = Collections.binarySearch(list, key);
        return idx >= 0 ? idx : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
