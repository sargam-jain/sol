//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean isValid(String str) {
        // Split the string by dots
        String[] parts = str.split("\\.");
        
        // There must be exactly 4 parts
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            // Check if the part is a valid number
            if (!isNumeric(part)) {
                return false;
            }
            
            int value = Integer.parseInt(part);
            
            // Check if the number is in the valid range and does not have leading zeros
            if (value < 0 || value > 255 || (part.length() > 1 && part.charAt(0) == '0')) {
                return false;
            }
        }
        
        return true;
    }
    
    // Helper method to check if a string is numeric
    private boolean isNumeric(String str) {
        // Regular expression to match digits only
        return str.matches("\\d+");
    }
}
