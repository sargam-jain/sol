//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        int n = arr.length;
        if(n==1) return arr[0].charAt(0) == arr[0].charAt(arr[0].length()-1) ? 1:0;
        
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<26; i++){
            graph.add(new ArrayList<>());
            
            
        }
        for(String word : arr){
        int firstChar = word.charAt(0) - 'a';
        int lastChar = word.charAt(word.length() - 1) - 'a';
        
        outDegree[firstChar]++;
        inDegree[lastChar]++;
        
        graph.get(firstChar).add(lastChar);
    }
    
    for(int i=0; i<26; i++){
        if(inDegree[i] != outDegree[i]){
            return 0;
        }
    }
    
    return isConnected(graph, arr[0].charAt(0) - 'a', inDegree, outDegree) ? 1:0;
    }
    
    public boolean isConnected(List<List<Integer>> graph, int start, int[] inDegree, int[] outDegree){
        
    
    
    boolean[] visited = new boolean[26];
    dfs(graph, start, visited);
    
    
    for(int i=0; i<26; i++){
    if((inDegree[i] > 0 || outDegree[i] > 0 )&& !visited[i]){
        return false;
    }
}
return true;

}
private void dfs(List<List<Integer>> graph, int node, boolean[] visited){
    visited[node] = true;
    for(int neighbour: graph.get(node)){
        if(!visited[neighbour]){
            dfs(graph, neighbour, visited);
        }
    }
}
}










