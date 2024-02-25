
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
        processMeetings(meetings, uf);
        return getResult(uf, n);
    }

    private void processMeetings(int[][] meetings, UnionFind uf) {
        for (int i = 0; i < meetings.length; ) {
            Set<Integer> pool = new HashSet<>();
            int time = meetings[i][2];

            while (i < meetings.length && time == meetings[i][2]) {
                int[] currMeeting = meetings[i];
                uf.union(currMeeting[0], currMeeting[1]);
                pool.add(currMeeting[0]);
                pool.add(currMeeting[1]);
                i++;
            }

            resetPeople(uf, pool);
        }
    }

    private void resetPeople(UnionFind uf, Set<Integer> pool) {
        for (int person : pool) {
            if (!uf.isConnected(0, person)) {
                uf.reset(person);
            }
        }
    }

    private List<Integer> getResult(UnionFind uf, int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (uf.isConnected(i, 0)) {
                result.add(i);
            }
        }

        return result;
    }
}

class UnionFind {
    public int[] group;

    public UnionFind(int n) {
        group = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            group[i] = i;
        }
    }

    private int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);

        if (x == y) {
            return;
        }

        group[x] = y;
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public void reset(int p) {
        group[p] = p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
