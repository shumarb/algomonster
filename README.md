# AlgoMonster

## Overview
This repository contains my solutions to questions listed on [AlgoMonster](https://algo.monster) across various topics, with submissions sourced from my [LeetCode](https://github.com/shumarb/leetcode) repository.

(*Note*: Rank indicates the percentage of submissions that my code outperforms in terms of runtime.)

| Topic                                         |
|-----------------------------------------------|
| [Binary Search](#binary-search)               |
| [Two Pointers](#two-pointers)                 |
| [Depth First Search](#depth-first-search)     |
| [Backtracking](#backtracking)                 |
| [Breadth First Search](#breadth-first-search) |
| [Priority Queue/Heap](#priority-queue--heap)  |
| [Dynamic Programming](#dynamic-programming)   |
| [Miscellaneous](#miscellaneous)               |

## Submissions
### Binary Search
| Question                                                                                                                   | Submission                                                                                                  | Runtime | Rank   | Category                | 
|----------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|---------|--------|-------------------------|
| [Vanilla Binary Search](https://algo.monster/problems/binary_search_intro)                                                 | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/BinarySearch.java)                         | 0ms     | 100%   | Basics                  |
| [First True in a Sorted Array](https://algo.monster/problems/binary_search_boundary)                                       | [Java](https://github.com/shumarb/algomonster/blob/main/submissions/FirstTrueInASortedArray.java)           | -       | -      | Basics                  |
| [First Element Not Smaller Than Target](https://algo.monster/problems/binary_search_first_element_not_smaller_than_target) | [Java](https://github.com/shumarb/algomonster/blob/main/submissions/FirstElementNotSmallerThanTarget.java)  | -       | -      | Sorted Array            |
| [First Occurrence](https://algo.monster/problems/binary_search_duplicates)                                                 | [Java](https://github.com/shumarb/algomonster/blob/main/submissions/FirstOccurrence.java)                   | -       | -      | Sorted Array            |
| [Square Root Estimation](https://leetcode.com/problems/sqrtx/description/)                                                 | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/SqrtX.java)                                | 1ms     | 87.09% | Sorted Array            |
| [Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)         | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/FindMinimumInRotatedSortedArray.java)      | 0ms     | 100%   | Implicitly Sorted Array |
| [Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/description/)                | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/PeakIndexInAMountainArray.java)            | 0ms     | 100%   | Implicitly Sorted Array |

### Two Pointers
| Question                                                                                                                                   | Submission                                                                                                            | Runtime | Rank   | Category            |
|--------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|---------|--------|---------------------|
| [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)                      | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/RemoveDuplicatesFromSortedArray.java)                | 1ms     | 64.98% | Same Direction      |
| [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/description/)                                          | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/MiddleOfTheLinkedList.java)                          | 0ms     | 100%   | Same Direction      |
| [Move Zeroes](https://leetcode.com/problems/move-zeroes/description/)                                                                      | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/MoveZeroes.java)                                     | 1ms     | 99.85% | Same Direction      |
| [Two Sum Sorted](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)                                | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/TwoInputSumTwoInputArrayIsSorted.java)               | 2ms     | 93.40% | Opposite Direction  |
| [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/)                                                            | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/ValidPalindrome.java)                                | 2ms     | 99.08% | Opposite Direction  |
| [Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/)                                          | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/ContainerWithMostWater.java)                         | 5ms     | 74.40% | Opposite Direction  |
| [Subarray Sum - Fixed](https://algo.monster/problems/subarray_sum_fixed)                                                                   | [Java](https://github.com/shumarb/algomonster/blob/main/submissions/SubarraySumFixed.java)                            | -       | -      | Sliding Windows     |
| [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/description/)                                  | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/FindAllAnagramsInAString.java)                       | 9ms     | 91.31% | Sliding Windows     |
| [Sliding Window - Longest](https://algo.monster/problems/subarray_sum_longest)                                                             | [Java](https://github.com/shumarb/algomonster/blob/main/submissions/FlexibleSizeSlidingWindowLongest.java)            | -       | -      | Sliding Windows     |
| [Longest Substring without Repeated Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/) | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/LongestSubstringWithoutRepeatedCharacters.java)      | 6ms     | 70.55% | Sliding Windows     |
| [Sliding Window - Shortest](https://algo.monster/problems/subarray_sum_shortest)                                                           | [Java](https://github.com/shumarb/algomonster/blob/main/submissions/FlexibleSizeSlidingWindowShortest.java)           | -       | -      | Sliding Windows     |
| [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)                                    | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/ProductOfArrayExceptSelf.java)                       | 2ms     | 89.32% | Prefix Sum          | 
| [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/description/)                                        | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/RangeSumQueryImmutable.java)                         | 8ms     | 65.10% | Prefix Sum          | 
| [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)                                                          | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/LinkedListCycle.java)                                | 0ms     | 100%   | Cycle Finding       | 

### Depth First Search
| Question                                                                                                                                    | Submission                                                                                                     | Runtime | Rank   | Category            |
|---------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|---------|--------|---------------------|
| [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)                                     | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/MaximumDepthOfBinaryTree.java)                | 0ms     | 100%   | DFS on Tree         |
| [Count Good Nodes in Binary Tree](https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/)                               | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/CountGoodNodesInBinaryTree.java)              | 1ms     | 100%   | DFS on Tree         |
| [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/description/)                                                     | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/BalancedBinaryTree.java)                      | 0ms     | 100%   | DFS on Tree         |
| [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/description/)                                               | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/SubtreeOfAnotherTree.java)                    | 2ms     | 97.86% | DFS on Tree         |
| [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/description/)                                                         | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/InvertBinaryTree.java)                        | 0ms     | 100%   | DFS on Tree         |
| [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/description/)                                       | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/ValidateBinarySearchTree.java)                | 0ms     | 100%   | Binary Search Tree  |
| [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/) | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/LowestCommonAncestorOfABinarySearchTree.java) | 5ms     | 100%   | Binary Search Tree  |
| [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)               | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/LowestCommonAncestorOfABinaryTree.java)       | 6ms     | 100%   | Binary Search Tree  |

### Backtracking
| Question                                                                                                                  | Submission                                                                                              | Runtime | Rank   | Category             |
|---------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|---------|--------|----------------------|
| [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/description/)                                         | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/BinaryTreePaths.java)                  | 1ms     | 98.42% | Combinatorial Search |
| [Backtracking I](https://algo.monster/problems/backtracking)                                                              | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/BacktrackingOne.java)                  | -       | -      | Combinatorial Search |
| [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/) | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/LetterCombinationsOfAPhoneNumber.java) | 0ms     | 100%   | Combinatorial Search |
| [Subsets](https://leetcode.com/problems/subsets/description/)                                                             | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/Subsets.java)                          | 0ms     | 100%   | Additional Practices |

### Breadth First Search
| Question                                                                                                                        | Submission                                                                                                    | Runtime | Rank   | Category        |
|---------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|---------|--------|-----------------|
| [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)               | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/BinaryTreeLevelOrderTraversal.java)          | 1ms     | 89.68% | BFS on Tree     |
| [Binary Tree ZigZag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/) | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/BinaryTreeZigZagLevelOrderTraversal.java)    | 1ms     | 69.75% | BFS on Tree     |
| [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/description/)                           | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/BinaryTreeRightSideView.java)                | 1ms     | 71.42% | BFS on Tree     |
| [Binary Tree Min Depth](https://algo.monster/problems/binary_tree_min_depth)                                                    | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/MinimumDepthOfBinaryTree.java)               | 2ms     | 89.35% | BFS on Tree     |

### Priority Queue / Heap
| Question                                                                                                                      | Submission                                                                                                 | Runtime | Rank   | Category        |
|-------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|---------|--------|-----------------|
| [Heap Fundamentals](https://algo.monster/problems/heap_intro)                                                                 | [Java](https://github.com/shumarb/algomonster/blob/main/submissions/HeapFundamentals.java)                 | -       | -      | Introduction    |
| [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/description/)                           | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/KClosestPointsToOrigin.java)              | 30ms    | 63.52% | Top K           |
| [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/description/)                                       | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/MergeKSortedLists.java)                   | 4ms     | 74%    | Top K           |
| [Kth Largest Element in An Array](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)                 | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/KthLargestElementInAnArray.java)          | 3ms     | 98.86% | Top K           |
| [Kth Smallest Element In A Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/) | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/KthSmallestElementInASortedMatrix.java)   | 11ms    | 65.35% | Top K           |
| [Ugly Number II](https://leetcode.com/problems/ugly-number-ii/description/)                                                   | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/UglyNumberTwo.java)                       | 2ms     | 98.25% | Moving Best     | 
| [Median of Data Stream](https://algo.monster/problems/median_of_data_stream)                                                  | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/MedianFinder.java)                        | 92ms    | 78.28% | Multiple Heaps  |

### Dynamic Programming
| Question                                                                        | Submission                                                                            | Runtime | Rank   | Category |
|---------------------------------------------------------------------------------|---------------------------------------------------------------------------------------|---------|--------|----------|
| [Unique Paths](https://leetcode.com/problems/unique-paths/description/)         | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/UniquePaths.java)    | 0ms     | 100%   | Grid     |
| [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/description/) | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/MinimumPathSum.java) | 3ms     | 71.06% | Grid     |

### Miscellaneous
| Question                                                                  | Submission                                                                            | Runtime | Rank   | Category |
|---------------------------------------------------------------------------|---------------------------------------------------------------------------------------|---------|--------|----------|
| [Insert Interval](https://leetcode.com/problems/insert-interval/)         | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/InsertInterval.java) | 2ms     | 31.53% | Interval |
