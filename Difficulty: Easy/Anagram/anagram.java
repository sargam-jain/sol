//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

 

        // Your code here
        if(s1.length()!=s2.length())return false;
        
        //define a freq array of size 26 coz no of alphabates inenglish are 26
        int freq[]=new int[26];
        
        //traverse in string 1
        for(int i=0; i<s1.length(); i++){
            char ch=s1.charAt(i);
            //find the index
            int ind=ch-'a';
            freq[ind]++;
        }
        //traversw in string 2;
         for(int i=0; i<s2.length(); i++){
            char ch=s2.charAt(i);
            //find the index
            int ind=ch-'a';
            freq[ind]--;
        }
        
        //check in freq array that string is anagram or bot
        for(int i=0; i<26; i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}