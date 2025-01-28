//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        Set<String> set = new HashSet<>();
        generate("",s,set);
        ArrayList<String> arr = new ArrayList<>(set);
        Collections.sort(arr);
        return arr;
    }
    private void generate(String p,String up,Set<String> set){
        if(up.isEmpty()){
            set.add(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String l = p.substring(0,i);
            String r = p.substring(i);
            generate(l + ch + r, up.substring(1),set);
        }
    }
}