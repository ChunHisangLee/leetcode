
//leetcode submit region begin(Prohibit modification and deletion)
class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            if (map.get(key).containsKey(timestamp)) {
                return map.get(key).get(timestamp);
            } else {
                Integer prev = map.get(key).floorKey(timestamp);
                if (prev != null) {
                    return map.get(key).get(prev);
                }
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)
