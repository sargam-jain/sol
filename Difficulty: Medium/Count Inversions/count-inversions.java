//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int count = 0;
    public static void merge(int arr[], int s, int mid, int e) {
        int temp[] = new int[e - s + 1];
        int i = s, j = mid + 1, k = 0;
        
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= e) {
            temp[k++] = arr[j++];
        }
        
        for (i = s, k = 0; i <= e; i++, k++) {
            arr[i] = temp[k];
        }
    }
    public static void mergeSort(int arr[], int s, int e) {
        if (s < e) {
            int mid = s + (e - s) / 2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid + 1, e);
            merge(arr, s, mid, e);
        }
    }
    static int inversionCount(int arr[]) {
        count = 0;
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }
}