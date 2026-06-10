class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i< nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }
        List<Integer> ans = new ArrayList();

        for(int i =buckets.length -1;i >= 0; i--){
            if(ans.size() >= k) break;
           if (buckets[i] == null) continue;
            ans.addAll(buckets[i]);
        }

        int[] ansArr = new int[k];
        for(int i = 0; i < ans.size();i++ ){
            ansArr[i] = ans.get(i);
        }
        
return ansArr;
    }
}
