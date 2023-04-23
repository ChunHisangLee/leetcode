/**
 * <p>Given an integer array <code>nums</code>, handle multiple queries of the following types:</p>
 *
 * <ol>
 * <li><strong>Update</strong> the value of an element in <code>nums</code>.</li>
 * <li>Calculate the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> where <code>left &lt;= right</code>.</li>
 * </ol>
 *
 * <p>Implement the <code>NumArray</code> class:</p>
 *
 * <ul>
 * <li><code>NumArray(int[] nums)</code> Initializes the object with the integer array <code>nums</code>.</li>
 * <li><code>void update(int index, int val)</code> <strong>Updates</strong> the value of <code>nums[index]</code> to be <code>val</code>.</li>
 * <li><code>int sumRange(int left, int right)</code> Returns the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> (i.e. <code>nums[left] + nums[left + 1] + ... + nums[right]</code>).</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * <strong>Output</strong>
 * [null, 9, null, 8]
 *
 * <strong>Explanation</strong>
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
 * <li><code>0 &lt;= index &lt; nums.length</code></li>
 * <li><code>-100 &lt;= val &lt;= 100</code></li>
 * <li><code>0 &lt;= left &lt;= right &lt; nums.length</code></li>
 * <li>At most <code>3 * 10<sup>4</sup></code> calls will be made to <code>update</code> and <code>sumRange</code>.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Design</li><li>Binary Indexed Tree</li><li>Segment Tree</li></div></div><br><div><li>👍 4269</li><li>👎 233</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] nums;
    int[] arr;
    int size;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        size = (int) Math.sqrt(n);
        arr = new int[(n + size - 1) / size];
        build();
    }

    private void build() {
        for (int i = 0; i < n; i++) {
            arr[i / size] += nums[i];
        }
    }

    public void update(int index, int val) {
        arr[index / size] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int start = left / size;
        int end = right / size;
        if (start == end) {
            int result = 0;
            for (int i = left; i <= right; i++) {
                result += nums[i];
            }
            return result;
        }
        int result = 0;
        start++;
        int nextarrtart = start * size;
        for (int i = left; i < nextarrtart; i++) {
            result += nums[i];
        }
        for (int i = start; i < end; i++) {
            result += arr[i];
        }
        for (int i = end * size; i <= right; i++) {
            result += nums[i];
        }
        return result;
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
