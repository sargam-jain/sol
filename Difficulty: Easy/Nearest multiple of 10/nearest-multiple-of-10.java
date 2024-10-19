//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    String roundToNearest(String str) {
        // Complete the function
        char[] ch=str.toCharArray();
        int n=ch.length;
        int carry=0;
        if(ch[n-1]>'5')carry=1;
        for(int i=n-2;i>=0 && carry!=0;i--){
            if(ch[i]=='9'){
                carry=1;
                ch[i]='0';
            }
            else{
                ch[i]++;
                carry=0;
            }
        }
        ch[n-1]='0';
        
        StringBuilder ans=new StringBuilder();
        if(carry==1) ans.append("1");     //  <------- in cases such as 9, 99, 999, 9999,etc...
        ans.append(String.valueOf(ch));
        
        return ans.toString();
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends