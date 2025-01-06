//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
       Arrays.sort(arr);
       List<Integer> ans = new ArrayList<>();
       int val = Integer.MAX_VALUE;
       int a=-1;
       int b=-1;
       int i=0;
       int j=arr.length-1;
       while(i<j){
           int sum = arr[i] + arr[j];
           if(sum == target){
               ans.add(arr[i]);
               ans.add(arr[j]);
               return ans;
           }else if(sum<target){
               int var = Math.abs(target-sum);
               if(var == val && b-a<arr[i] - arr[j]){
                   b = arr[j];
                   a=arr[i];
               }else if(var<val){
                   val = var;
                   b=arr[j];
                   a=arr[i];
               }
               i++;
           }
           else{
               int var=Math.abs(target-sum);
                   if(var==val && b-a<arr[j]-arr[i]){
                       b=arr[j];
                       a=arr[i];
                   }
                   else if(var<val){
                       val = var;
                       b=arr[j];
                       a=arr[i];
                   }
                   j--;
               }
           }
           if(a==-1){
               return ans;
           }
           ans.add(a);
           ans.add(b);
           return ans;
           
       
    }
}