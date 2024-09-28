//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        
        // dp[i] will store the minimum cost to reach stone i
        int[] dp = new int[n];
        
        // Initialize the dp array to a large number initially
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Starting at the first stone with 0 cost
        dp[0] = 0;
        
        // Fill the dp array using the recurrence relation
        for (int i = 1; i < n; i++) {
            // Check all stones from i-1 to i-k and find the minimum cost
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(arr[i] - arr[i - j]));
                }
            }
        }
        
        // The result is the minimum cost to reach the last stone
        return dp[n - 1];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends