class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for(int i = 0; i< strs.length; i++){
            int[] arr = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                arr[strs[i].charAt(j)-'a']++;

            }
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j< arr.length;j++){
                sb.append(arr[j]).append("!");
            }
            String key = sb.toString();
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(strs[i]);

        }
        return new ArrayList<>(ans.values());  
    }
}
