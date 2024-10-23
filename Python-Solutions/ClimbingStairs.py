class Solution(object):
    def climbStairs(self, n):
        if n == 1:
            return 1
        first = 1
        second = 2
        for i in range(3, n + 1):
            firsty = first + second
            first = second
            second = firsty
        return second
