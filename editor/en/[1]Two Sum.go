//leetcode submit region begin(Prohibit modification and deletion)
func twoSum(nums []int, target int) []int {
	numMap := make(map[int]int)

	for i, num := range nums {
		complement := target - num

		if index, found := numMap[complement]; found {
			return []int{index, i}
		}

		numMap[num] = i
	}

	return []int{}
}

//leetcode submit region end(Prohibit modification and deletion)
