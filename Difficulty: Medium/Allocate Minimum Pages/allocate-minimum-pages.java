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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java


        class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int m)
    {
        int n = arr.length;
        if(m>n)
        return -1;
        
        int start =0, end =0, mid, ans=0;
        for(int i=0;i<n;i++){
            if(start <arr[i])
            start = arr[i];
            end +=arr[i];
        }
        
        while(start<=end){
            mid = start +(end-start)/2;
            int pages =0;
            int count = 1;
            for(int i=0;i<n;i++){
                pages+=arr[i];
                if(pages>mid){
                    count++;
                    
                    pages = arr[i];
                }
                
            }
            if(count <=m){
                ans = mid;
                end = mid-1;
            }
            else
            start = mid+1;
        }
        return ans;
    }
}