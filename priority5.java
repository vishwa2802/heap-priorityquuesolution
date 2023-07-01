import java.util.*;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // stores the smaller half of the elements
    private PriorityQueue<Integer> minHeap; // stores the larger half of the elements
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Add the number to the appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        // Balance the heaps to ensure the sizes differ by at most 1
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // Determine the median based on the sizes of the heaps
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
    
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        System.out.println("After reading 1st element of stream - 5 -> median - " + medianFinder.findMedian());
        medianFinder.addNum(15);
        System.out.println("After reading 2nd element of stream - 5, 15 -> median - " + medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println("After reading 3rd element of stream - 5, 15, 1 -> median - " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("After reading the 4th element of stream - 5, 15, 1, 3 -> median - " + medianFinder.findMedian());
    }
}
