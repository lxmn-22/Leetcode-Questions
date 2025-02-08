/*
PROBLEM: 2349: Design a Number Container System

Design a number container system that can do the following:

Insert or Replace a number at the given index in the system.
Return the smallest index for the given number in the system.
Implement the NumberContainers class:

NumberContainers() Initializes the number container system.
void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
 
Example 1:
Input
["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
[[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
Output
[null, -1, null, null, null, null, 1, null, 2]

Explanation
NumberContainers nc = new NumberContainers();
nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
nc.change(2, 10); // Your container at index 2 will be filled with number 10.
nc.change(1, 10); // Your container at index 1 will be filled with number 10.
nc.change(3, 10); // Your container at index 3 will be filled with number 10.
nc.change(5, 10); // Your container at index 5 will be filled with number 10.
nc.find(10); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20. 
nc.find(10); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
*/
class NumberContainers {
	private _index2Num: Map<number, number>;
	private _num2Indexes: Map<number, BinaryHeap<number>>;
	private _compareFn: CompareFn<number>;

	constructor() {
		this._index2Num = new Map();
		this._num2Indexes = new Map();
		this._compareFn = (index1, index2) => index1 - index2;
	}

	change(index: number, number: number): void {
		// If previous and current numbers are equal
		if (number == this._index2Num.get(index)) {
			return;
		}

		// Update the index number
		this._index2Num.set(index, number);

		// Get or create the number's heap of indexes
		let heap = this._num2Indexes.get(number);
		if (heap == null) {
			heap = new BinaryHeap(this._compareFn);
			this._num2Indexes.set(number, heap);
		}

		// Add the index to the number's heap
		heap.push(index);
	}

	find(number: number): number {
		// Get the number's heap
		const heap = this._num2Indexes.get(number);

		// If it does not exist, the number has no indexes
		if (heap == null) {
			return -1;
		}

		// Remove indexes that have been changed to another number
		while (heap.size > 0 && this._index2Num.get(heap.peek()) != number) {
			heap.pop();
		}

		// If the number has no indexes
		if (heap.size == 0) {
			// Remove the number's index heap
			this._num2Indexes.delete(number);
			return -1;
		}

		// Return the smallest index
		return heap.peek();
	}
}

type CompareFn<T> = (a: T, b: T) => number;

class BinaryHeap<T> {
	protected compare: CompareFn<T>;
	protected values: T[];

	constructor(compare: CompareFn<T>) {
		this.compare = compare;
		this.values = [];
	}

	get size(): number {
		return this.values.length;
	}

	peek(): T | undefined {
		return this.values[0];
	}

	pop(): T | undefined {
		if (this.values.length < 2) {
			return this.values.pop();
		}

		const value = this.values[0];
		this.values[0] = this.values.pop();
		sinkDown(this.values, this.compare, 0);

		return value;
	}

	push(value: T): number {
		const len = this.values.push(value);
		bubbleUp(this.values, this.compare, len - 1);
		return len;
	}
}

function bubbleUp<T>(array: T[], compareFn: CompareFn<T>, index: number): void {
	const value = array[index];

	while (index > 0) {
		const parentI = (index - 1) >> 1;
		if (compareFn(array[parentI], value) <= 0) {
			break;
		}
		array[index] = array[parentI];
		index = parentI;
	}
	array[index] = value;
}

function sinkDown<T>(array: T[], compareFn: CompareFn<T>, index: number): void {
	const value = array[index];
	const N = array.length - 1;
	const M = (N + 1) >> 1;

	while (index < M) {
		let child = (index << 1) + 1;
		child += +(child < N && compareFn(array[child], array[child + 1]) >= 0);
		if (compareFn(value, array[child]) <= 0) {
			break;
		}
		array[index] = array[child];
		index = child;
	}
	array[index] = value;
}
