// 49
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //hashmap,哈希表
        //读取每个单词
        //["bat"],["nat","tan"],["ate","eat","tea"]
        //0 <= strs[i].length <= 100  //0-100之间的质数
        int [] alphabet=new int[]{3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,103,107};//质数表，哈希计算，1自己，无法整除

        Map<Long,List<String>>map=new HashMap<>();//哈希，返回结果，数字计算最快，
        long Key;//键  求模计算，速度最快
        int length=0;//长度
        for(String str:strs){//循环每个字符串
            Key=1l;//long类型的1
            length=str.length();//取得字符串的长度
            for(int i=0;i<length;i++){
                Key *=alphabet[str.charAt(i)-'a'];//乘以质数，确保不重复
                //任何一个字符，
            }
            List <String> l=map.getOrDefault(Key,new ArrayList<String>());
            l.add(str);//符合重复的
            map.putIfAbsent(Key,l);//保存结果

        }
        return new ArrayList(map.values());//返回结果，转化数组
    }
}
 */