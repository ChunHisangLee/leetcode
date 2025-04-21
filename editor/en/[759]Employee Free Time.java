// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> allIntervals = new ArrayList<>();

    for (List<Interval> employee : schedule) {
      allIntervals.addAll(employee);
    }

    Collections.sort(
        allIntervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
    List<Interval> mergedIntervals = new ArrayList<>();
    Interval prev = allIntervals.get(0);

    for (int i = 1; i < allIntervals.size(); i++) {
      Interval curr = allIntervals.get(i);

      if (curr.start <= prev.end) {
        prev.end = Math.max(prev.end, curr.end);
      } else {
        mergedIntervals.add(prev);
        prev = curr;
      }
    }

    mergedIntervals.add(prev);
    List<Interval> freeTime = new ArrayList<>();

    for (int i = 1; i < mergedIntervals.size(); i++) {
      Interval prevMerged = mergedIntervals.get(i - 1);
      Interval currMerged = mergedIntervals.get(i);

      if (currMerged.start > prevMerged.end) {
        freeTime.add(new Interval(prevMerged.end, currMerged.start));
      }
    }

    return freeTime;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
