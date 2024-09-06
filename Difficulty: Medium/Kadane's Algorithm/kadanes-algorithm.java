//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // Function to find the sum of the contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {
        // Initialize variables to track current subarray sum and max sum
        long maxSum = Long.MIN_VALUE;  // or arr[0] for the first element
        long currentSum = 0;
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Add the current element to the current sum or start new subarray
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            
            // Update the max sum encountered so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
