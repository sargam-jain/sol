//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        int nonZeroIndex = 0; // Keeps track of the position to place the next non-zero element
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap the non-zero element with the element at nonZeroIndex
                int temp = arr[nonZeroIndex];
                arr[nonZeroIndex] = arr[i];
                arr[i] = temp;
                nonZeroIndex++; // Move the nonZeroIndex forward
            }
        }
    }
}
