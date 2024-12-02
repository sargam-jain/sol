//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    // Searches for all occurrences of the pattern 'pat' in the text 'txt' using the KMP algorithm.
    ArrayList<Integer> search(String pat, String txt) {
        int[] prefix=new int[pat.length()];
        for(int i=1,cnt=0;i<pat.length();){
            if(pat.charAt(i)==pat.charAt(cnt))
            prefix[i++]=++cnt;
            else if(cnt==0) i++;
            else cnt=prefix[cnt-1];
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0,j=0;i<txt.length();i++){
            while(j>0 && pat.charAt(j)!=txt.charAt(i))
            j=prefix[j-1];
            
            if(pat.charAt(j)==txt.charAt(i))
            j++;
            if(j==pat.length()){
               ans.add(i-j+1);
               j=prefix[j-1];
            }
        }
        return ans;
    }
}