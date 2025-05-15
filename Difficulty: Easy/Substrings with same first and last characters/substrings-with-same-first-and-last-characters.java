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
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        // code here
        int[] freq = new int[26]; // since s contains only lowercase letters

        // Count frequencies of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int count = 0;

        // For each character, apply the formula: freq * (freq + 1) / 2
        for (int f : freq) {
            count += (f * (f + 1)) / 2;
        }

        return count;
    }
}