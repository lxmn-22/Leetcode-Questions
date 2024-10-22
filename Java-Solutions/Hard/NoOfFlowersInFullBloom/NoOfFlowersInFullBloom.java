/*
You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] 
means the ith flower will be in full bloom from starti to endi (inclusive). 
You are also given a 0-indexed integer array people of size n, 
where people[i] is the time that the ith person will arrive to see the flowers.

Return an integer array answer of size n, where answer[i] is the number of flowers that are in 
full bloom when the ith person arrives.

Constraints:
1 <= flowers.length <= 5 * 104
flowers[i].length == 2
1 <= starti <= endi <= 109
1 <= people.length <= 5 * 104
1 <= people[i] <= 109
 */
import java.util.*;
class NoOfFlowersInFullBloom {
    public static int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[] ans = new int[persons.length];
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for (int[] flower : flowers) {
            starts.add(flower[0]);
            ends.add(flower[1]);
        }

        Collections.sort(starts);
        Collections.sort(ends);

        for (int i = 0; i < persons.length; ++i) {
            final int started = firstGreater(starts, persons[i]);
            final int ended = firstGreaterEqual(ends, persons[i]);
            ans[i] = started - ended;
        }
        return ans;
    }

  // Finds the first index l s.t A.get(l) > target.
  // Returns A.size() if can't find.
    private static int firstGreater(List<Integer> A, int target) {
        int l = 0;
        int r = A.size();
        while (l < r) {
            final int m = (l + r) / 2;
            if (A.get(m) > target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

  // Find the first index l s.t A.get(l) >= target
  // Returns A.size() if can't find
    private static int firstGreaterEqual(List<Integer> A, int target) {
        int l = 0;
        int r = A.size();
        while (l < r) {
            final int m = (l + r) / 2;
            if (A.get(m) >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
    public static void main(String[] args) {
        int[][] flowers = {{1,6},{3,7},{9,12},{4,13}};
        int[] persons = {2,3,7,11};
        System.out.println(fullBloomFlowers(flowers, null));
    }
}
