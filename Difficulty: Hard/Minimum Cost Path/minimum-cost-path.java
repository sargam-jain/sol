//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
static class Cell implements Comparable<Cell>{
    int x, y, cost;
    Cell(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    public int compareTo(Cell other){
        return this.cost - other.cost;
    }
}
    public int minimumCostPath(int[][] grid){
        int N = grid.length;
        int[][] dist = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        dist[0][0] = grid[0][0];
        pq.add(new Cell(0,0, dist[0][0]));
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!pq.isEmpty()){
            Cell current = pq.poll();
            int x = current.x;
            int y = current.y;
            
            if(x==N-1 && y==N-1){
                return dist[x][y];
            }
        
        if(visited[x][y]) continue;
        visited[x][y] = true;
        
        for(int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx>=0 && nx < N && ny>=0 && ny < N){
                int newCost = dist[x][y] + grid[nx][ny];
            
            if(newCost < dist[nx][ny]){
                dist[nx][ny] = newCost;
                pq.add(new Cell(nx,ny, newCost));
            }
        }
        }
    }
        return dist[N-1][N-1];
        
    }
}