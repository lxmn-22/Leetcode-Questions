class Solution:
    def isHappy(self, n):
        def get_sum_of_squares(num):
            total = 0
            while num > 0:
                digit = num % 10
                total += digit * digit
                num //= 10
            return total

        seen = []
        while n != 1:
            if n in seen:
                return False
            seen.append(n)
            n = get_sum_of_squares(n)
        
        return True
