import java.util.*;

/*
LeetCode 2402 : Meeting Rooms III

Idea:
- Use two priority queues:
  1) availableRooms → free rooms (smallest room number first)
  2) busyRooms → ongoing meetings (earliest end time first)

Logic:
- Sort meetings by start time
- Free rooms that have finished before current meeting
- If a room is available → assign it
- Else → delay meeting to the earliest free room
- Count meetings per room and return the room with maximum count

Complexity:
- Time: O(m log n)
- Space: O(n)
*/

class MeetingRooms {

    public int mostBooked(int n, int[][] meetings) {

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Free rooms (min room number first)
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        // Busy rooms: {endTime, roomNumber}
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? (int)(a[1] - b[1]) : (int)(a[0] - b[0])
        );

        // Initialize all rooms as free
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }

        // Count meetings per room
        int[] count = new int[n];

        // Process each meeting
        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free rooms that have finished
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.add((int) busyRooms.poll()[1]);
            }

            // Assign room
            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                busyRooms.add(new long[]{end, room});
                count[room]++;
            } else {
                // Delay meeting
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];

                busyRooms.add(new long[]{newEnd, room});
                count[room]++;
            }
        }

        // Find room with maximum meetings
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
