class KthLargest {
    PriorityQueue<Integer> heap;
    int kth;
    public KthLargest(int k, int[] nums) {
       this.heap = new PriorityQueue<Integer>();
        for(int i = 0; i < nums.length; i++){
            heap.offer(nums[i]);
            if(heap.size() > k){
                heap.poll();
            }
        }
        this.kth = k;
    }
    
    public int add(int val) {
        
        heap.offer(val);
        if(heap.size() > kth){
            heap.poll();
        }
        return heap.peek();
    }
}
