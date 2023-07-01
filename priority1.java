import java.util.*;

public class RearrangeString {
    public static String rearrangeString(String s) {
        // Create a character count map to store the frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Create a max-heap to store the characters based on their frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));
        maxHeap.addAll(charCount.keySet());
        
        // Create a StringBuilder to store the rearranged string
        StringBuilder sb = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            
            // If the character is the same as the last one in the StringBuilder, try to find the next most frequent character
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == current) {
                if (maxHeap.isEmpty()) {
                    return ""; // No possible rearrangement
                }
                
                char next = maxHeap.poll();
                sb.append(next);
                
                // Decrease the count of the next character in the character count map
                charCount.put(next, charCount.get(next) - 1);
                
                // Add the current character back to the max-heap if its count is still greater than 0
                if (charCount.get(current) > 0) {
                    maxHeap.offer(current);
                }
            } else {
                sb.append(current);
                
                // Decrease the count of the current character in the character count map
                charCount.put(current, charCount.get(current) - 1);
                
                // Add the current character back to the max-heap if its count is still greater than 0
                if (charCount.get(current) > 0) {
                    maxHeap.offer(current);
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s1 = "aab";
        System.out.println("Input 1: s = \"aab\"");
        System.out.println("Output 1: " + rearrangeString(s1));
        
        String s2 = "aaab";
        System.out.println("Input 2: s = \"aaab\"");
        System.out.println("Output 2: " + rearrangeString(s2));
    }
}
