//{ Driver Code Starts
import java.io.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    public int minTime(int[] arr1, int[] arr2) {
        int count = 0;
        int count1 = 0;
        for(int i=0; i<arr1.length; i++){
            if(i%2 == 0){
                count += arr1[i];
            }else {
            count += arr2[i];
            }
        }
        for(int j=0; j<arr1.length; j++){
            if(j%2 ==0 ){
                count1 += arr2[j];
            }else {
            count1 += arr1[j];
            }
        }
        return Math.min(count, count1);
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (t-- > 0) {
            // Read input for arr1
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            int[] arr1 = new int[inputArray.length];
            for (int i = 0; i < inputArray.length; i++) {
                arr1[i] = Integer.parseInt(inputArray[i]);
            }

            // Read input for arr2
            input = scanner.nextLine();
            inputArray = input.split(" ");
            int[] arr2 = new int[inputArray.length];
            for (int i = 0; i < inputArray.length; i++) {
                arr2[i] = Integer.parseInt(inputArray[i]);
            }

            Solution solution = new Solution();
            System.out.println(solution.minTime(arr1, arr2));
        }
        scanner.close();
    }
}

// } Driver Code Ends