/*
PROBLEM: 2182: Construct String With Repeat Limit

You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.

Return the lexicographically largest repeatLimitedString possible.

A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.

Example 1:
Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
The letter 'a' appears at most 1 time in a row.
The letter 'c' appears at most 3 times in a row.
The letter 'z' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.

Example 2:
Input: s = "aababab", repeatLimit = 2
Output: "bbabaa"
Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa". 
The letter 'a' appears at most 2 times in a row.
The letter 'b' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
*/
// function repeatLimitedString(s: string, repeatLimit: number): string {
//     let pairHeap = new PriorityQueue({compare: (a, b) => (b[0].charCodeAt(0) - a[0].charCodeAt(0))});

//     let HashMap: Map<string, number> = new Map();

//     for(let i = 0; i < s.length; i++) {
//         let char = s[i];

//         if(HashMap.has(char)) {
//             let count = HashMap.get(char);
//             if(count) {
//                 HashMap.set(char, count + 1);
//             }
//         } else {
//             HashMap.set(char, 1);
//         }
//     }
//     HashMap.forEach((value, key) => {
//         pairHeap.enqueue([key, value]);
//     })

//     let currentString : string[] = [];

//     while(!pairHeap.isEmpty()) {
//         let [a, b] = pairHeap.front();
//         pairHeap.dequeue();

//         if(b > repeatLimit) {
//             for(let i = 0; i < repeatLimit; i++) {
//                 currentString.push(a);
//                 b--;
//             }
//         } else {
//             while(b--) {
//                 currentString.push(a);
//             }
//             continue;
//         }
//         if(pairHeap.isEmpty()) {
//             break;
//         }

//         let [c, d] = pairHeap.front();
//         currentString.push(c);
//         d--;
//         pairHeap.dequeue();

//         if(b > 0) {
//             pairHeap.enqueue([a, b]);
//         }
//         if(d > 0) {
//             pairHeap.enqueue([c, d]);
//         }
//     }
//     return currentString.join('');
// };