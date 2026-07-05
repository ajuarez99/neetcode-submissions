class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0; 
        int ans = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap();
        for(int r = 0; r< s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) +1);
            count = Math.max(count, map.get(s.charAt(r)));
            while((r-l + 1) - count > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) -1 );
                l++;
            }
            ans = Math.max(ans, r-l +1);
        }
        return ans;
    }
}
