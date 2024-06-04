package main

// leetcode submit region begin(Prohibit modification and deletion)
func longestPalindrome(s string) int {
	arr := make([]int, 128)

	for _, c := range s {
		arr[c]++
	}

	count := 0

	for _, num := range arr {
		count += num / 2 * 2

		if count%2 == 0 && num%2 == 1 {
			count++
		}
	}

	return count
}

//leetcode submit region end(Prohibit modification and deletion)
