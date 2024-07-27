//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Method to count the minimum number of insertions needed to make the string a palindrome
    static int countMin(String str) {
        if (isPalindrome(str)) {
            return 0; // If the string is already a palindrome, no insertions are needed
        }

        int n = str.length();
        int[][] dp = new int[n][n];

        // Build the table for dynamic programming
        for (int gap = 1; gap < n; gap++) {
            for (int l = 0, h = gap; h < n; l++, h++) {
                if (str.charAt(l) == str.charAt(h)) {
                    dp[l][h] = dp[l + 1][h - 1];
                } else {
                    dp[l][h] = Math.min(dp[l][h - 1], dp[l + 1][h]) + 1;
                }
            }
        }

        return dp[0][n - 1]; // Minimum insertions needed for the entire string
    }

    // Helper method to check if a given string is a palindrome
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "your_input_string_here";
        System.out.println("Minimum insertions needed to make the string a palindrome: " + countMin(str));
    }
}
