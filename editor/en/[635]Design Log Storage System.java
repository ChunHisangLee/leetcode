
//leetcode submit region begin(Prohibit modification and deletion)
class LogSystem {
    int MULTIPLE = 100;
    String[] GRANULARITIES = {"Second", "Minute", "Hour", "Day", "Month", "Year"};
    HashMap<Long, Integer> mp;

    public LogSystem() {
        mp = new HashMap<>();
    }

    public void put(int id, String timestamp) {
        long key = getKey(timestamp);
        mp.put(key, id);

    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        long startKey = getKey(start);
        long endKey = getKey(end);
        long factor = 1;

        for (String str : GRANULARITIES) {
            if (str.equals(granularity)) {
                break;
            }

            factor *= MULTIPLE;
        }

        startKey = startKey / factor * factor;
        endKey = (endKey / factor + 1) * factor - 1;
        List<Integer> ans = new ArrayList<Integer>();

        for (long k : mp.keySet()) {
            if (k >= startKey && k <= endKey) {
                ans.add(mp.get(k));
            }
        }

        return ans;
    }

    public long getKey(String timestamp) {
        long key = 0;
        int length = timestamp.length();

        for (int i = 0; i < length; i++) {
            if (Character.isDigit(timestamp.charAt(i))) {
                key = key * 10 + timestamp.charAt(i) - '0';
            }
        }

        return key;
    }
}


/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
//leetcode submit region end(Prohibit modification and deletion)
