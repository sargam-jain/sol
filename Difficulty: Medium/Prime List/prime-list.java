//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // code here
        Node curr=head;
        while(curr!=null){
            if(!isPrime(curr.val)) curr.val=nearestPrime(curr.val);
            curr=curr.next;
        }
        return head;
    }
    private int nearestPrime(int n){
        if(n==1) return 2;
        int leftPrime=-1,rightPrime=-1;
        for(int i=n;i>1;i--){
            if(isPrime(i)){
                leftPrime=i;
                break;
            }
        }
        for(int i=n;i<n*n;i++){
            if(isPrime(i)){
                rightPrime=i;
                break;
            }
        }
        int leftDis=n-leftPrime,rightDis=rightPrime-n;
        return leftDis==rightDis?leftPrime:leftDis<rightDis?leftPrime:rightPrime;
    }
    private boolean isPrime(int n){
        if(n==1) return false;
        if(n==2) return true;
        for(int i=2;i<n/2+1;i++) if(n%i==0) return false;
        return true;
    }
}