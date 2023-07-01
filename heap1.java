import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) {
            pq.offer(num);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 2, 6, 9};
        int k1 = 3;
        System.out.println("Input 1: arr[] = {1, 2, 3, 5, 2, 6, 9}, k = 3");
        System.out.println("Output 1: " + findKthLargest(arr1, k1));
        
        int[] arr2 = {1, 7, 8, 5, 2, 6, 9};
        int k2 = 6;
        System.out.println("Input 2: arr[] = {1, 7, 8, 5, 2, 6, 9}, k = 6");
        System.out.println("Output 2: " + findKthLargest(arr2, k2));
    }
}
