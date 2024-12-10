//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
       int res = 0;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int start = -1, end = -1;
        for(int[] interval: intervals) {
            if(interval[0] < end) {
                end = Math.min(end, interval[1]);
                res++;
                continue;
            }
            start = interval[0];
            end = interval[1];
        }
        return res;


    }
}
