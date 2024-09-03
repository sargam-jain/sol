//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public long nthStair(int n) {
        int count =0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
        
        if(i + j*2 == n){
    
        
        count += 1;
        }
            }
        }
        return count;
    }
}