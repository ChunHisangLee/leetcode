# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        xor_sum = 0;

        for num in nums:
            xor_sum ^= num

        dif_bits = xor_sum ^ k
        return bin(dif_bits).count('1');
# leetcode submit region end(Prohibit modification and deletion)
