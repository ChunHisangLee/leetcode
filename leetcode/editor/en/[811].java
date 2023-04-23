811
        Subdomain Visit Count
        2023-03-04 10:45:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int space = cpdomain.indexOf(" ");
            int count = Integer.parseInt(cpdomain.substring(0, space));
            String domain = cpdomain.substring(space + 1);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String curr = domain.substring(i + 1);
                    map.put(curr, map.getOrDefault(curr, 0) + count);
                }
            }
            map.put(domain, map.getOrDefault(domain, 0) + count);
        }
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(key)).append(" ").append(key);
            list.add(sb.toString());
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)