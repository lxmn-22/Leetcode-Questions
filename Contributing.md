# Contributing to [LeetCode-Solutions](https://github.com/lxmn-22/Leetcode-Questions) Repository

### Hey coder! 👋

Thank you for considering contributing to this repository! Your contributions will help others learn and grow by sharing your LeetCode solutions. Please take a moment to review the guidelines below before submitting your contributions.

### How to Contribute

#### 1. Fork the Repository

Start by forking the repository to your own GitHub account. You can do this by clicking the **Fork** button at the top of the repository page.

<img width="1800" alt="Screenshot 2024-10-22 at 4 07 35 PM" src="https://github.com/user-attachments/assets/7776e7d9-d2f6-4cf1-bdd3-ca91195f23ed">

#### 2. Clone Your Fork

Clone your fork of the repository to your local machine:

```bash
git clone https://github.com/lxmn-22/leetcode-solutions.git

cd leetcode-solutions
```

#### 3. Create a New Branch

```bash
git checkout -b add-solution-<question-title>
```

#### 4. Add Your Solution

- Go to the relevant problem folder or create a new folder if it does not exist.

- File names should follow this format: problemname.(extention -> py or js etc.)
  
    For example: HappyNumber.py for Python or AddTwoPromises.js for Javascript.

- Add a comment at the top of your file with:
  
    The problem statement.

- Example for Javascript solution:
```js
/*
Given two promises promise1 and promise2, return a new promise. promise1 and promise2 
will both resolve with a number. The returned promise should resolve with the sum of 
the two numbers.

Example 1:
Input: 
promise1 = new Promise(resolve => setTimeout(() => resolve(2), 20)), 
promise2 = new Promise(resolve => setTimeout(() => resolve(5), 60))
Output: 7
Explanation: The two input promises resolve with the values of 2 and 5 respectively. 
The returned promise should resolve with a value of 2 + 5 = 7. The time the returned 
promise resolves is not judged for this problem.

Example 2:
Input: 
promise1 = new Promise(resolve => setTimeout(() => resolve(10), 50)), 
promise2 = new Promise(resolve => setTimeout(() => resolve(-12), 30))
Output: -2
Explanation: The two input promises resolve with the values of 10 and -12 respectively. 
The returned promise should resolve with a value of 10 + -12 = -2.
*/
/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    const[value1, value2] = await Promise.all([promise1, promise2]);
    return value1 + value2;
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */
```

#### 5. Commit and Push Your Changes

After you've added your solution, commit your changes:

```bash
git add .
git commit -m "Added solution for <question-title>"
```

Push your branch to your forked repository:

```bash
git push origin add-solution-<question-title>
```

#### 6. Submit a Pull Request

Go to the original repository and create a new pull request from your branch. Please provide a detailed description of the problem and the solution you’re contributing.

#### 7. Wait for Review

Repository maintainer will review your submission and provide feedback if necessary. Once approved, your solution will be merged into the repository!

## Contribution Guidelines:

- Code Quality: Ensure that your solution is clean, well-documented, and follows the best practices for your chosen language.
  
- Test Cases: Your solution should handle all edge cases and must pass all test cases provided by LeetCode.
  
- File Naming: Follow the file naming convention as described above.
  
- Avoid Duplicate Solutions: Before submitting a solution, check to ensure that the same solution has not already been added. If you have a more efficient approach, feel free to submit it as an improvement.

## Code of Conduct:

By participating in this project, you agree to uphold a respectful and welcoming environment for all contributors.

## Thank You for Contributing!

We appreciate you for contributing to the Repository! Your efforts help create a rich learning environment for all. Together, we can build a comprehensive resource that aids countless developers in mastering coding challenges.

If you have any questions or need assistance during your contribution, feel free to reach out, and we look forward to seeing your solutions!

---
