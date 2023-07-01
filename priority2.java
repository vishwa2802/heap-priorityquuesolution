import java.util.*;

public class KSmallestPairs {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Create a min-heap to store the pairs based on their sums
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        
        // Add the pairs to the min-heap
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                List<Integer> pair = new ArrayList<>();
                pair.add(num1);
                pair.add(num2);
                minHeap.offer(pair);
            }
        }
        
        // Create a List to store the result pairs
        List<List<Integer>> result = new ArrayList<>();
        
        // Extract the k smallest pairs from the min-heap
        while (k > 0 && !minHeap.isEmpty()) {
            result.add(minHeap.poll());
            k--;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println("Input 1: nums1 = [1, 7, 11], nums2 = [2, 4, 6], k = 3");
        System.out.println("Output 1: " + kSmallestPairs(nums1, nums2, k));
        
        int[] nums3 = {1, 1, 2};
        int[] nums4 = {1, 2, 3};
        k = 2;
        System.out.println("Input 2: nums1 = [1, 1, 2], nums2 = [1, 2, 3], k = 2");
        System.out.println("Output 2: " + kSmallestPairs(nums3, nums4, k));
        
        int[] nums5 = {1, 2};
        int[] nums6 = {3};
        k = 3;
        System.out.println("Input 3: nums1 = [1, 2], nums2 = [3], k = 3");
        System.out.println("Output 3: " + kSmallestPairs(nums5, nums6, k));
    }
}
