//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String a, String b) {
       
        a = a.replaceFirst("^0+", "");
        b = b.replaceFirst("^0+", "");
        
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int c = 0;
        int base = 2;
        StringBuilder res = new StringBuilder();
        
        while (n1 >= 0 || n2 >= 0) {
            int t1 = 0;
            int t2 = 0;

            if (n1 >= 0) {
                t1 = a.charAt(n1--) - '0';
            }
            if (n2 >= 0) {
                t2 = b.charAt(n2--) - '0';
            }
            
            int sum = t1 + t2 + c;
            c = sum / base; 
            res.append(sum % base); 
        }
        
        if (c == 1) {
            res.append(c); 
        }
        
        return res.reverse().toString();
    }
}