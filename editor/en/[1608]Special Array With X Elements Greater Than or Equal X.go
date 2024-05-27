//leetcode submit region begin(Prohibit modification and deletion)
func specialArray(nums []int) int {
	sort.Ints(nums)
	n := len(nums)

	if nums[0] >= n {
		return n
	}

	for i := 1; i < n; i++ {
		if nums[i] >= n-i {
			if nums[i-1] >= n-i {
				return -1
			}
			return n - i
		}
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)
