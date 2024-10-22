/*
You are given an array of variable pairs equations and an array of real numbers values, 
where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. 
Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where 
you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result 
in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer 
cannot be determined for them.

Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0
*/
package Medium.EvaluateDivision;

public class EvaluateDivision {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Set<String>> connectionMap = new HashMap<>();
        Map<String, Double> valueMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String equation = equations.get(i).get(0) + "/" + equations.get(i).get(1);
            connectionMap.computeIfAbsent(equations.get(i).get(0), k -> new HashSet<>()).add(equations.get(i).get(1));
            connectionMap.computeIfAbsent(equations.get(i).get(1), k -> new HashSet<>()).add(equations.get(i).get(0));
            valueMap.put(equation, values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            String source = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            double[] res = { -1.0 };
            dfs(connectionMap, valueMap, source, target, new HashSet<>(), res, 1.0);
            ans[i] = res[0];
        }
        return ans;
    }

    private static void dfs(Map<String, Set<String>> connectionMap, Map<String, Double> valueMap, String source,
            String target, Set<String> visited, double[] res, double currVal) {
        if (source.equals(target) && (connectionMap.containsKey(source) || connectionMap.containsKey(target))) {
            res[0] = currVal;
            return;
        }
        for (String connection : connectionMap.getOrDefault(source, new HashSet<>())) {
            if (!visited.contains(connection)) {
                visited.add(connection);
                double newwCurrVal = currVal
                        * (valueMap.containsKey(source + "/" + connection) ? valueMap.get(source + "/" + connection)
                                : (1 / valueMap.get(connection + "/" + source)));
                dfs(connectionMap, valueMap, connection, target, visited, res, newwCurrVal);
            }
        }
    }
}