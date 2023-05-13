
//leetcode submit region begin(Prohibit modification and deletion)
class AuthenticationManager {
    int timeToLive;
    Map<String, Integer> map;
    TreeSet<Integer> set;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
        set = new TreeSet<>();
    }

    public void generate(String tokenId, int currentTime) {
        deleteExpiredToken(currentTime);
        map.put(tokenId, currentTime + timeToLive);
        set.add(currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        deleteExpiredToken(currentTime);
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
            set.remove(map.get(tokenId));
            map.put(tokenId, currentTime + timeToLive);
            set.add(currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        deleteExpiredToken(currentTime);
        return set.size();
    }

    private void deleteExpiredToken(int currentTime) {
        while (!set.isEmpty() && set.first() <= currentTime) {
            set.remove(set.first());
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
//leetcode submit region end(Prohibit modification and deletion)
