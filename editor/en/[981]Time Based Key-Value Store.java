// leetcode submit region begin(Prohibit modification and deletion)
class TimeMap {
  private static class Entry {
    final int timestamp;
    final String value;

    Entry(int timestamp, String value) {
      this.timestamp = timestamp;
      this.value = value;
    }
  }

  private final Map<String, List<Entry>> store;

  public TimeMap() {
    store = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (store.get(key) == null) {
      store.put(key, new ArrayList<>());
    }

    store.get(key).add(new Entry(timestamp, value));
  }

  public String get(String key, int timestamp) {
    List<Entry> list = store.get(key);

    if (list == null || list.isEmpty()) {
      return "";
    }

    if (list.get(0).timestamp > timestamp) {
      return "";
    }

    int left = 0;
    int right = list.size() - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midTS = list.get(mid).timestamp;

      if (midTS == timestamp) {
        return list.get(mid).value;
      } else if (midTS < timestamp) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return list.get(right).value;
  }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp); String param_2 = obj.get(key,timestamp);
 */
// leetcode submit region end(Prohibit modification and deletion)
