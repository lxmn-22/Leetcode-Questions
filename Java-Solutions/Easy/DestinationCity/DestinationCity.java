/*
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there
 * exists a direct
 * path going from cityAi to cityBi. Return the destination city, that is, the
 * city without any
 * path outgoing to another city.
 * 
 * It is guaranteed that the graph of paths forms a line without any loop,
 * therefore, there will
 * be exactly one destination city.
 * 
 * Example 1:
 * Input: paths =
 * [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which
 * is the
 * destination city. Your trip consist of: "London" -> "New York" -> "Lima" ->
 * "Sao Paulo".
 */
class DestinationCity {
    public static String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>();
        Set<String> outgoingCities = new HashSet<>();
        for (List<String> path : paths) {
            cities.addAll(path);
            outgoingCities.add(path.get(0));
        }
        cities.removeAll(outgoingCities);
        return cities.iterator().next();
    }
}