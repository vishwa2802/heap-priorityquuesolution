import java.util.PriorityQueue;

public class ConnectRopes {
    public static int minimumCost(int[] ropes) {
        // Create a min-heap to store the lengths of the ropes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all the rope lengths to the min-heap
        for (int rope : ropes) {
            minHeap.offer(rope);
        }
        
        int totalCost = 0;
        
        // Merge the ropes until there is only one rope left in the min-heap
        while (minHeap.size() > 1) {
            // Extract the two smallest ropes from the min-heap
            int rope1 = minHeap.poll();
            int rope2 = minHeap.poll();
            
            // Calculate the cost of merging the two ropes
            int cost = rope1 + rope2;
            
            // Add the cost to the total cost
            totalCost += cost;
            
            // Add the merged rope back to the min-heap
            minHeap.offer(cost);
        }
        
        return totalCost;
    }
    
    public static void main(String[] args) {
        int[] ropes = {5, 4, 2, 8};
        int minCost = minimumCost(ropes);
        System.out.println("The minimum cost is: " + minCost);
    }
}
