1720
        Decode XORed Array
        2023-02-23 18:19:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] arr = new int[n + 1];
        arr[0] = first;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
The inverse is XOR!

If you have:

c = a^b;
You can get a or b back if you have the other value available:

a = c^b; // or b^c (order is not important)
b = c^a; // or a^c

encoded[i] = arr[i] ^ arr[i+1]

Here we have an encoded array, and we want a resultant array, so we can interchange

res[0] = first
res[i+1] = res[i] ^ encoded[i]
 */