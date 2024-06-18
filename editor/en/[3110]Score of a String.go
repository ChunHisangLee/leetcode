//leetcode submit region begin(Prohibit modification and deletion)
func scoreOfString(s string) int {
	n := len(s)
	sum := 0

	for i := 1; i < n; i++ {
		sum += int(math.Abs(float64(s[i]) - float64(s[i-1])))
	}

	return sum
}

//leetcode submit region end(Prohibit modification and deletion)
