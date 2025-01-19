/*
PROBLEM: 407: Trapping Rain Water II

Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D
elevation map, return the volume of water it can trap after raining.

Example 1:
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.

Example 2:
Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
*/
class Solution
{
public:
    typedef pair<int, pair<int, int>> PP;
    vector<vector<int>> directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    int trapRainWater(vector<vector<int>> &heightMap)
    {
        int m = heightMap.size();
        int n = heightMap[0].size();

        // min-heap { height, {i, j}}
        priority_queue<PP, vector<PP>, greater<>> boundaryCells;

        vector<vector<bool>> visited(m, vector<bool>(n, false));

        // left most column & right most column(o, n-1).
        for (int row = 0; row < m; row++)
        {
            for (int col : {0, n - 1})
            {
                boundaryCells.push({heightMap[row][col], {row, col}});
                visited[row][col] = true;
            }
        }

        // top most row & bottom most row(o, m-1).
        for (int col = 0; col < n; col++)
        {
            for (int row : {0, m - 1})
            {
                boundaryCells.push({heightMap[row][col], {row, col}});
                visited[row][col] = true;
            }
        }

        int water = 0;
        // Time Complexity: O(m*n * log(m*n))
        // Space Complexity: O(m*n)
        while (!boundaryCells.empty())
        {
            PP p = boundaryCells.top();
            boundaryCells.pop();

            int height = p.first;
            int i = p.second.first;
            int j = p.second.second;

            // find neighbours.
            for (vector<int> &dir : directions)
            {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_])
                {
                    water += max(height - heightMap[i_][j_], 0);

                    boundaryCells.push({max(height, heightMap[i_][j_]), {i_, j_}});

                    visited[i_][j_] = true;
                }
            }
        }
        return water;
    }
};