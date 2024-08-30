//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> queens = new ArrayList<>();
        solveNQueens(n, 0, queens, result);
        return result;
    }

    private void solveNQueens(int n, int row, ArrayList<Integer> queens, ArrayList<ArrayList<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(queens));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(queens, row, i)) {
                queens.add(i + 1); // i + 1 because the output is 1-based index
                solveNQueens(n, row + 1, queens, result);
                queens.remove(queens.size() - 1);
            }
        }
    }

    private boolean isSafe(ArrayList<Integer> queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int qCol = queens.get(i) - 1;
            // Check if two queens are in the same column or diagonals
            if (qCol == col || Math.abs(qCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
