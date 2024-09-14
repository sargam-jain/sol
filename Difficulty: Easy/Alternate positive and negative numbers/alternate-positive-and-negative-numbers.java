//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        if(arr.size() == 2 && arr.get(0) < 0 && arr.get(1) >= 0){
            int temp = arr.get(0);
            arr.set(0,arr.get(1));
            arr.set(1,temp);
        }
        for(int j=0; j<arr.size();j++){
            if(arr.get(j) < 0){
                list.add(arr.get(j));
                
            }
            
        }
        arr.removeAll(list);
        int i=1;
        for(int num : list){
            if(i<arr.size()){
            
            arr.add(i,num);
            }else{
                arr.add(num);
            }
            
            i+=2;
        }
    }
}