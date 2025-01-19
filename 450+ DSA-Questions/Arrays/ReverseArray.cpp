/*
PROBLEM: Array Reverse

Given an array arr[], the task is to reverse the array. Reversing an array means rearranging
the elements such that the first element becomes the last, the second element becomes second
last and so on.

Examples1:
Input: arr[] = {1, 4, 3, 2, 6, 5}
Output: {5, 6, 2, 3, 4, 1}
Explanation: The first element 1 moves to last position, the second element 4 moves to
second-last and so on.

Examples2:
Input: arr[] = {4, 5, 1, 2}
Output: {2, 1, 5, 4}
Explanation: The first element 4 moves to last position, the second element 5 moves to
second last and so on.
*/
#include <iostream>
#include <vector>
using namespace std;

// Brute Force
// function to reverse the array elements.
void reverseArray(vector<int> &arr)
{
    int n = arr.size();

    // temp array, stores elements in reversed order.
    vector<int> temp(n);

    // copy elements into temp array from original arr.
    for (int i = 0; i < n; i++)
    {
        temp[i] = arr[n - i - 1];
    }

    // copy temp elements to original arr.
    for (int i = 0; i < n; i++)
    {
        arr[i] = temp[i];
    }
}

// Two-Pointer
void reverseArray(vector<int> &arr)
{
    int left = 0;
    int right = arr.size() - 1;

    while (left < right)
    {
        swap(arr[left], arr[right]);
        left++;
        right--;
    }
}

// Recursion
void reverseArrayRecursion(vector<int> &arr, int left, int right)
{
    if (left > right)
    {
        return;
    }

    swap(arr[left], arr[right]);

    reverseArrayRecursion(arr, left + 1, right - 1)
}

void reverseArray(vector<int> &arr)
{
    int n = arr.size();
    reverseArrayRecursion(arr, 0, n - 1);
}