//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        if ( arr == null || arr.length == 0){
            return "-1";
            
        }
        String prefix = arr[0];
        for(int i = 0 ; i < arr.length ; i ++){
            prefix = findCommonPrefix(prefix, arr[i]);
            if(prefix.isEmpty()){
                return "-1";
            }
            
        }
        return prefix;
    }
    private String findCommonPrefix(String str1, String str2){
        int minLength = Math.min(str1.length() , str2.length());
        int i = 0;
        while(i < minLength && str1.charAt(i) == str2.charAt(i)){
            i ++;
        }
        return str1.substring(0, i);
    }
}