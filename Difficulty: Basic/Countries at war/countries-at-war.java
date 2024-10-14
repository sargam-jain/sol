//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            ArrayList<Integer> array2 = new ArrayList<Integer>();

            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            line = read.readLine();
            tokens = line.split(" ");
            for (String token : tokens) {
                array2.add(Integer.parseInt(token));
            }

            // ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr1 = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr1[idx++] = i;

            int[] arr2 = new int[array2.size()];
            idx = 0;
            for (int i : array2) arr2[idx++] = i;

            String v = new Solution().countryAtWar(arr1, arr2);

            // for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println(v);

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String countryAtWar(int[] arr1, int[] arr2) {
       int countA = 0;
       int countB = 0;
       for(int i=0;i<arr1.length;i++){
           if(arr1[i] > arr2[i]){
               countA += 1;
           }else if(arr1[i] < arr2[i]){
               countB += 1;
           }
       }
       if(countA > countB){
           return "A";
       }else if(countB > countA){
           return "B";
       }
       
       return "DRAW";
       
    }
}