class Solution {
    public int search(int[] nums, int target) {
        int l =0, r = nums.length -1, pivot;
        while(l <= r){
            pivot = (l + r) /2;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot]> target){
                r =  pivot - 1;
            }
            else if(nums[pivot] < target){
                l = pivot + 1;
            }
        }
        return -1;
    }
}
