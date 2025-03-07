/*
PROBLEM: 2523: Closest Prime Numbers in Range

Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

Example 1:
Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.

Example 2:
Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
*/
function closestPrimes(left: number, right: number): number[] {
	const primeNum: number[] = [];
	const isPrime = (n: number): boolean => {
		if (n < 2) {
			return false;
		}
		if (n === 2 || n === 3) {
			return true;
		}
		if (n % 2 === 0 || n % 3 === 0) {
			return false;
		}

		for (let i = 5; i * i <= n; i += 6) {
			if (n % i === 0 || n % (i + 2) === 0) {
				return false;
			}
		}
		return true;
	};

	for (let i = left; i <= right; i++) {
		if (isPrime(i)) {
			const last = primeNum.length ? primeNum[primeNum.length - 1] : -1;

			if (last != -1 && i - last <= 2) {
				return [last, i];
			}
			primeNum.push(i);
		}
	}

	if (primeNum.length === 2) {
		return primeNum;
	}

	return [-1, -1];
}
