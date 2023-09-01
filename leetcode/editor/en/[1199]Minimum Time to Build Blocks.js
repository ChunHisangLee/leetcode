//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} blocks
 * @param {number} split
 * @return {number}
 */
var minBuildTime = function (blocks, split) {
    const heap = new MinPriorityQueue();
    for (const block of blocks) {
        heap.enqueue(block);
    }
    while (heap.size() > 1) {
        const block1 = heap.dequeue().element;
        const block2 = heap.dequeue().element;
        heap.enqueue(block2 + split);
    }
    return heap.dequeue().element;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
function minBuildTime(blocks, split) {
  // Initialize the priority queue (min heap) with blocks
  const minHeap = blocks.slice();
  minHeap.sort((a, b) => a - b);

  // Helper function to remove the smallest element from the heap
  const removeMin = () => {
    const min = minHeap[0];
    let last = minHeap.pop();
    if (minHeap.length > 0) {
      minHeap[0] = last;
      bubbleDown(0);
    }
    return min;
  };

  // Helper function to add a new element to the heap
  const offer = (val) => {
    minHeap.push(val);
    bubbleUp(minHeap.length - 1);
  };

  // Helper function to maintain heap property while adding an element
  const bubbleUp = (index) => {
    while (index > 0) {
      const parentIndex = Math.floor((index - 1) / 2);
      if (minHeap[index] >= minHeap[parentIndex]) break;
      [minHeap[index], minHeap[parentIndex]] = [minHeap[parentIndex], minHeap[index]];
      index = parentIndex;
    }
  };

  // Helper function to maintain heap property while removing an element
  const bubbleDown = (index) => {
    while (true) {
      const left = 2 * index + 1,
            right = 2 * index + 2,
            length = minHeap.length;
      let smallest = index;
      if (left < length && minHeap[left] < minHeap[smallest]) smallest = left;
      if (right < length && minHeap[right] < minHeap[smallest]) smallest = right;
      if (smallest === index) break;
      [minHeap[index], minHeap[smallest]] = [minHeap[smallest], minHeap[index]];
      index = smallest;
    }
  };

  // Main algorithm to find the minimum build time
  while (minHeap.length > 1) {
    const block1 = removeMin();
    const block2 = removeMin();
    offer(block2 + split);
  }

  return minHeap[0];
}

The problem "1199. Minimum Time to Build Blocks" can be solved using a Min Heap or Priority Queue
in JavaScript. Below is the complete JavaScript code using a Priority Queue implemented with an array:

In this code, I first populate the minHeap with the given blocks and then sort it to maintain the
heap property. I then provide helper functions removeMin and offer to remove the minimum element
and add a new element, respectively, while keeping the heap property intact.
The bubbleUp and bubbleDown methods are helper functions to maintain the heap property while
adding or removing elements.

Finally, I use the main algorithm to find the minimum build time, which involves repeatedly
taking the two smallest blocks, building one, and then re-inserting the other with added split time,
until only one block remains. The time required for that final block is the answer.

The minBuildTime function should solve the problem efficiently, with a time complexity of O(n log n).

 */