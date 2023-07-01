public class SolitaireGame {
    public static int maximumScore(int a, int b, int c) {
        int[] piles = {a, b, c};
        int score = 0;
        
        while (true) {
            // Sort the piles in descending order
            Arrays.sort(piles);
            if (piles[1] == 0) {
                break; // No more available moves
            }
            
            // Take one stone from the two largest piles
            piles[2]--;
            piles[1]--;
            score++;
        }
        
        return score;
    }
    
    public static void main(String[] args) {
        int a = 2, b = 4, c = 6;
        System.out.println("Input: a = 2, b = 4, c = 6");
        System.out.println("Output: " + maximumScore(a, b, c));
    }
}
