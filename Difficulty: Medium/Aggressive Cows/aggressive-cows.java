//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Step 1: Sort the stalls
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Mid represents the distance we are testing
            if (canPlaceCows(stalls, k, mid)) { // Step 2: Check if cows can be placed with 'mid' distance
                result = mid; // Update result to the valid 'mid'
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }

        return result;
    }

    // Helper function to check if cows can be placed with at least 'distance' between them
    private static boolean canPlaceCows(int[] stalls, int k, int distance) {
        int count = 1; // Place the first cow at the first stall
        int lastPosition = stalls[0]; // Position of the last placed cow

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) { // Check if we can place the next cow
                count++;
                lastPosition = stalls[i]; // Update the position of the last placed cow
            }
            if (count >= k) { // If all cows are placed successfully
                return true;
            }
        }

        return false; // Not possible to place all cows
    }
}
