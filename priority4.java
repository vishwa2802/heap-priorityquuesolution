import java.util.*;

public class KthSmallestSum {
    public static int kthSmallestSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Create a min-heap to store the sums
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add the sum of the first row elements to the min-heap
        for (int j = 0; j < n; j++) {
            minHeap.offer(mat[0][j]);
        }
        
        // Compute the sums for the remaining rows
        for (int i = 1; i < m; i++) {
            PriorityQueue<Integer> nextHeap = new PriorityQueue<>();
            
            // Generate the sums by combining the elements from the current row with the previous sums
            while (!minHeap.isEmpty()) {
                int sum = minHeap.poll();
                for (int j = 0; j < n; j++) {
                    nextHeap.offer(sum + mat[i][j]);
                }
            }
            
            // Keep only the k smallest sums
            int count = 0;
            while (count < k && !nextHeap.isEmpty()) {
                minHeap.offer(nextHeap.poll());
                count++;
            }
        }
        
        // Return the kth smallest sum
        return minHeap.poll();
    }
    
    public static void main(String[] args) {
        int[][] mat1 = {{1, 3, 11}, {2, 4, 6}};
        int k1 = 5;
        System.out.println("Input 1: mat = [[1, 3, 11], [2, 4, 6]], k = 5");
        System.out.println("Output 1: " + kthSmallestSum(mat1, k1));
        
        int[][] mat2 = {{1, 3, 11}, {2, 4, 6}};
        int k2 = 9;
        System.out.println("Input 2: mat = [[1, 3, 11], [2, 4, 6]], k = 9");
        System.out.println("Output 2: " + kthSmallestSum(mat2, k2));
        
        int[][] mat3 = {{1, 10, 10}, {1, 4, 5}, {2, 3, 6}};
        int k3 = 7;
        System.out.println("Input 3: mat = [[1, 10, 10], [1, 4, 5], [2, 3, 6]], k = 7");
        System.out.println("Output 3: " + kthSmallestSum(mat3, k3));
    }
}
