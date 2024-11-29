/*
PROBLEM: Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]
*/
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

// function inorderTraversal(root: TreeNode | null): number[] {
//     if(!root) {
//         return [];
//     }

//     let current = root;
//     let stash = [];
//     let result = [];

//     while(stash.length || current) {
//         while(current) {
//             stash.push(current);
//             current = current.left;
//         }
//         let node = stash.pop();
//         result.push(node.val);
//         current = node.right;
//     }
//     return result;
// };