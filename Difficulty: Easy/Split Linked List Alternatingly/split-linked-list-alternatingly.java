//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to split a linked list into two lists alternately
    Node[] alternatingSplitList(Node head) {
        if (head == null) return new Node[] {null, null}; // Handle empty list

        // Initialize two heads for the new lists
        Node list1Head = head; // First list starts from head
        Node list2Head = head.next; // Second list starts from the second node

        // Initialize pointers for the two lists
        Node list1 = list1Head;
        Node list2 = list2Head;

        // Traverse the list and split nodes alternately
        while (list1 != null && list1.next != null) {
            list1.next = list1.next.next; // Move list1 pointer to next alternate node
            list1 = list1.next; // Move to next node in list1

            if (list2 != null && list2.next != null) {
                list2.next = list2.next.next; // Move list2 pointer to next alternate node
                list2 = list2.next; // Move to next node in list2
            }
        }

        // Return the two split lists
        return new Node[] {list1Head, list2Head};
    }
}

