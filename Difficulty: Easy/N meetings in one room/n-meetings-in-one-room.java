//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int[] start, int[] end) {
        // List to hold pairs of (end, start) times.
        List<int[]> meetings = new ArrayList<>();

        // Fill the list with meeting time pairs.
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{end[i], start[i]});
        }

        // Sort the list by end times. If end times are the same, sort by start times.
        Collections.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Initialize the count of meetings and end time of the last selected meeting.
        int count = 0;
        int lastEndTime = 0;

        // Iterate over sorted meetings to select the maximum number of non-overlapping meetings.
        for (int[] meeting : meetings) {
            if (meeting[1] > lastEndTime) {
                // If the start time of the current meeting is greater than the last end time,
                // select the meeting.
                count++;
                lastEndTime = meeting[0];
            }
        }

        return count;
    }
}
