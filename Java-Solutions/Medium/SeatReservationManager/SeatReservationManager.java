/*
Design a system that manages the reservation state of n seats that are numbered from 1 to n.
Implement the SeatManager class:
SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n.
All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.

Example 1:
Input
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
Output
[null, 1, 2, null, 2, 3, 4, 5, null]
*/
class SeatReservationManager {
    PriorityQueue<Integer> pq;
    int count;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        count = 1;
    }

    public int reserve() {
        if (pq.size() == 0) {
            return count++;
        }
        return pq.remove();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */