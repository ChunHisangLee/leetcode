// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> allSchedules = new ArrayList<>();

    for (List<Interval> employee : schedule) {
      allSchedules.addAll(employee);
    }

    Collections.sort(
        allSchedules, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

    List<Interval> merged = new ArrayList<>();
    Interval prevInterval = allSchedules.get(0);

    for (int i = 1; i < allSchedules.size(); i++) {
      Interval currInterval = allSchedules.get(i);

      if (currInterval.start <= prevInterval.end) {
        prevInterval.end = Math.max(prevInterval.end, currInterval.end);
      } else {
        merged.add(prevInterval);
        prevInterval = currInterval;
      }
    }

    merged.add(prevInterval);

    List<Interval> freeTime = new ArrayList<>();

    for (int i = 1; i < merged.size(); i++) {
      Interval prev = merged.get(i - 1);
      Interval curr = merged.get(i);

      if (prev.end < curr.start) {
        freeTime.add(new Interval(prev.end, curr.start));
      }
    }

    return freeTime;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
