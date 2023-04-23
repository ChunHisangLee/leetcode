/**
 * <p>Implement a SnapshotArray that supports the following interface:</p>
 *
 * <ul>
 * <li><code>SnapshotArray(int length)</code> initializes an array-like data structure with the given length. <strong>Initially, each element equals 0</strong>.</li>
 * <li><code>void set(index, val)</code> sets the element at the given <code>index</code> to be equal to <code>val</code>.</li>
 * <li><code>int snap()</code> takes a snapshot of the array and returns the <code>snap_id</code>: the total number of times we called <code>snap()</code> minus <code>1</code>.</li>
 * <li><code>int get(index, snap_id)</code> returns the value at the given <code>index</code>, at the time we took the snapshot with the given <code>snap_id</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * <strong>Output:</strong> [null,null,0,null,5]
 * <strong>Explanation: </strong>
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5</pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= length &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= index &lt; length</code></li>
 * <li><code>0 &lt;= val &lt;= 10<sup>9</sup></code></li>
 * <li><code>0 &lt;= snap_id &lt; </code>(the total number of times we call <code>snap()</code>)</li>
 * <li>At most <code>5 * 10<sup>4</sup></code> calls will be made to <code>set</code>, <code>snap</code>, and <code>get</code>.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li><li>Binary Search</li><li>Design</li></div></div><br><div><li>👍 1988</li><li>👎 286</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class SnapshotArray {
    List<Map<Integer, Integer>> list;

    public SnapshotArray(int length) {
        list = new ArrayList();
        list.add(new HashMap());
    }

    public void set(int index, int val) {
        int snapId = list.size() - 1;
        list.get(snapId).put(index, val);
    }

    public int snap() {
        list.add(new HashMap());
        return list.size() - 2;
    }

    public int get(int index, int snap_id) {
        for (int snap = snap_id; snap >= 0; snap--) {
            if (list.get(snap).containsKey(index))
                return list.get(snap).get(index);
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
//leetcode submit region end(Prohibit modification and deletion)
