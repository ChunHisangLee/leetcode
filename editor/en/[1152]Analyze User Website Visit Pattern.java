/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> res = new ArrayList<>();
        TrieNode head = new TrieNode();
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            list.add(new Entry(username[i], timestamp[i], website[i]));
        }
        list.sort(Comparator.comparingInt(entry -> entry.time));
        for (Entry entry : list) {
            if (!head.users.contains(entry.username)) {
                head.users.add(entry.username);
            }
            head.addChild(entry.username, entry.website);
        }

        while (!head.children.isEmpty()) {
            head = getWeb(head, res);
        }
        return res;
    }

    TrieNode getWeb(TrieNode head, List<String> res) {
        String[] webArr = head.children.keySet().toArray(new String[0]);
        Arrays.sort(webArr, (s1, s2) -> head.children.get(s2).count - head.children.get(s1).count == 0 ? s1.compareTo(s2) : head.children.get(s2).count - head.children.get(s1).count);
        res.add(webArr[0]);
        return head.children.get(webArr[0]);
    }

    class Entry {
        String username;
        int time;
        String website;

        Entry(String username, int time, String website) {
            this.username = username;
            this.time = time;
            this.website = website;
        }
    }

    class TrieNode {
        int level = 0;
        String website = null;
        int count = 0;
        Map<String, TrieNode> children = new HashMap<>();
        Set<String> users = new HashSet<>();

        int addChild(String username, String website) {
            if (!users.contains(username)) {
                return 0;
            }
            if (level < 2) {
                for (String childWeb : children.keySet()) {
                    count = Math.max(count, children.get(childWeb).addChild(username, website));
                }
            }
            TrieNode childNode;
            if (!children.containsKey(website)) {
                childNode = new TrieNode();
                childNode.website = website;
                childNode.level = level + 1;
                children.put(website, childNode);
            }
            childNode = children.get(website);
            if (!childNode.users.contains(username)) {
                if (childNode.level == 3) {
                    childNode.count++;
                }
                childNode.users.add(username);
            }
            if (childNode.level == 3) {
                count = Math.max(count, childNode.count);
            }
            return count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
