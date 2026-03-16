package fourth;

import java.util.PriorityQueue;

public class KthLargest {
    static int solve(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        System.out.println(solve(nums, k));
    }
}
