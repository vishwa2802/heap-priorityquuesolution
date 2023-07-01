import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        // Create a HashMap to store the frequency of each word
        Map<String, Integer> wordFreq = new HashMap<>();
        
        // Calculate the frequency of each word
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        
        // Create a PriorityQueue with a custom comparator to sort the words
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int freq1 = wordFreq.get(word1);
                int freq2 = wordFreq.get(word2);
                
                // If the frequencies are equal, sort lexicographically
                if (freq1 == freq2) {
                    return word2.compareTo(word1);
                }
                
                // Sort by frequency in descending order
                return freq1 - freq2;
            }
        });
        
        // Add the words to the PriorityQueue
        for (String word : wordFreq.keySet()) {
            pq.offer(word);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // Create a List to store the result
        List<String> result = new ArrayList<>();
        
        // Add the words from the PriorityQueue to the result in reverse order
        while (!pq.isEmpty()) {
            result.add(0, pq.poll());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println("Input 1: words = [\"i\",\"love\",\"leetcode\",\"i\",\"love\",\"coding\"], k = 2");
        System.out.println("Output 1: " + topKFrequent(words1, k1));
        
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println("Input 2: words = [\"the\",\"day\",\"is\",\"sunny\",\"the\",\"the\",\"the\",\"sunny\",\"is\",\"is\"], k = 4");
        System.out.println("Output 2: " + topKFrequent(words2, k2));
    }
}
