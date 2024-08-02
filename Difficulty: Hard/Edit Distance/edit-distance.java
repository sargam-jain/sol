//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D dp array
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the dp array
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // Deleting all characters from str1 to match an empty str2
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // Inserting all characters of str2 to match an empty str1
        }

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // Characters match, no extra operation needed
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], // Replace
                                Math.min(dp[i][j - 1],    // Insert
                                         dp[i - 1][j]));  // Remove
                    dp[i][j] += 1;  // Add the cost of the operation
                }
            }
        }

        // Return the edit distance between the full strings
        return dp[m][n];
    }
}