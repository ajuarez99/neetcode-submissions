class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[128];
        int l = 0;
        int max = 0;
        for(int i =0; i< s.length();i++){

            charMap[s.charAt(i)]++;
            while(charMap[s.charAt(i)] > 1){
                charMap[s.charAt(l)]--;
                l++;
            } 
            max= Math.max(max, i-l +1);
        }
    return max;
    }
}
