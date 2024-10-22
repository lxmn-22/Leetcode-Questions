/*Question: You are given two 2D integer arrays, items1 and items2, representing two sets of items. 
Each array items has the following properties:
items[i] = [valuei, weighti] where valuei represents the value and weighti represents the weight of the ith item.
The value of each item in items is unique.
Return a 2D integer array ret where ret[i] = [valuei, weighti], with weighti being the sum of weights of all items with value valuei.

Note: ret should be returned in ascending order by value. */

public class MergeSimilarItems {
      public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] item : items1) {
                  map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
            }
            for (int[] item : items2) {
                  map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
            }
            List<List<Integer>> result = new ArrayList<>();
            for (Integer key : map.keySet()) {
                  result.add(Arrays.asList(key, map.get(key)));
            }
            Collections.sort(result, Comparator.comparing(o -> o.get(0)));
      return result;
      }
}