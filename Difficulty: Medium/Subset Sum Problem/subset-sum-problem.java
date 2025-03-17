//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean dp[][] = new Boolean[n][sum+1];
        return rec(dp,sum,n-1,arr);
        
    }
    private static boolean rec(Boolean[][] dp,int sum, int id, int arr[]){
        if(sum==0) return true;
        if(sum<0 || id<0) return false;
        if(dp[id][sum] != null) return dp[id][sum];
        Boolean p=rec(dp,sum-arr[id], id-1,arr);
        Boolean np =rec(dp,sum,id-1,arr);
        return dp[id][sum]=p||np;
    }
    
}