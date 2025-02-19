//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        int[][] res = new int[k][2];
        PriorityQueue<Pair1> queue = new PriorityQueue<>((a,b)->{
            return b.dis-a.dis;});
        for(int i=0;i<points.length;i++){
            int val1 = points[i][0];
            int val2 = points[i][1];
            int dis = val1*val1 + val2*val2;
            queue.add(new Pair1(dis,val1,val2));
            if(queue.size()>k){
                queue.remove();
            }
            
            
        }
        for(int i=0;i<k;i++){
            Pair1 p = queue.remove();
            res[i][0]=p.x;
            res[i][1]=p.y;
            
        }
        return res;
    }
    class Pair1 {
        int dis;
        int x;
        int y;
    
    public Pair1(int dis,int x,int y){
        this.dis=dis;
        this.x=x;
        this.y=y;
    }
    
        
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends