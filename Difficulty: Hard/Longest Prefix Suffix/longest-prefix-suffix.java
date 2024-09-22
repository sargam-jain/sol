//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        int n = str.length();
        int[] lps = new int[n];
        
        // Length of the previous longest prefix suffix
        int length = 0;
        int i = 1;
        
        // lps[0] is always 0, so we start with i = 1
        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // If there is a mismatch, we check if we can fall back to a shorter length
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    // If we can't fall back, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // The last value of the lps array gives the longest proper prefix which is also a suffix
        return lps[n - 1];
    }
}
