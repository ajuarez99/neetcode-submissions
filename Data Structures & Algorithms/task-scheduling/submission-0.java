class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] charMap = new int[26];
        for(int i = 0; i < tasks.length; i++){
            charMap[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i = 0; i< 26; i++){
            if(charMap[i] > 0){
                maxHeap.offer(charMap[i]);
            }
        }
        Queue<int[]> queue = new LinkedList();

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
            int count = maxHeap.poll() -1;
            if(count > 0){
                queue.offer(new int[] { count, time + n});
            }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.add(queue.poll()[0]);
            }
        }
        return time;
    }
}
