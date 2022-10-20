# Algorithm Repository for UCD - COMP20290 - Algorithms

This repository is a collection of the algorithms covered in the assignments and practicals of COMP20290.
Each folder represents an assignment or practical and are programmed in Java.

## Getting Started
### Prerequisites
* Install JDK 17 from Oracle [here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Algorithms - 

### Sorting Algorithms
#### Bogo Sort
Bogo sort is a sorting algorithm which randomly suffles a list or an array and continues to do so until they are sorted.
The time complexity of bogo sort in its best case is O(1), with its average being undefined and its worst case being infinite.
The space complexity of this algorithm is 1, as it is just held in memory and shuffled.
#### Bubble Sort
Bubble sort is a sorting algorithm which compared different elements in a list or an array and swaps the to achieve a sorted list or array.
The time complexity of this approach is at best O(n), with an average case of O(n^2) and worst case of O(n^2).
The space complexity of this algorithm is 1, as it is just held in memory while the items are moved around.
#### Selection Sort
Selection sort is an in place sorting algorithm which steps throughout a list or an array multiple times moving items until it is sorted.
The time complexity of this algorithm is O(n^2).
With a space complexity of 1, as it is held in memory while the items are moved around.
#### Merge Sort
Merge sort is a sorting algorithm which breaks an array or list into smaller sub lists, then sorts and re-assembles these lists.
The time complexity of this approach is O(n log n)
The space complexity of this approach is n.
#### Quick Sort
The quicksort inwhich sorting is done around a pivot, where items are swaped and this proccess is repeated until it is completely sorted.
The time complexity of this algorithm is O(n log n), with its worst case being O(n^2).
The space complexity is at best log n and at worst n.
* Sorting Algorithms [here](../main/sorting/src/Sorting.java)


### Binary Search
Binary search is an algorithm which works on an already sorted dataset, it works by comparing the center point of this dataset to then determine if it should search the left side or right side of this point. It then repeats this proccess until the item is found or there is no more elemets to search for.
The time complexity of this algorithm is log n.
The space complexity of this algorithm is 1.
* Binary Search Algorithm [here](../main/binary-search/src/Search.java)


### String Search
#### Brute Force
This algorithm searchs for a substring by brute force, essentailly searching multiple permutations of the input until the substring found.
The time complexity of this is O(nm) where n is input size and m is search pattern size.
The space complextiy of this is n + m.
#### Knuth-Morris-Pratt
The KMP algorithm essentially uses what we learn about the string as we progress through it to speed up string searching.
The time complexity of this O(m(n-m+1)).
The space complexity of this is n + m
* String Search Algorithms [here](../main/string-search/src/stringSearch.java)


### Huffman Compression
Huffman compression is a compression algorithm which builds a dictionary in the shape of a tree (based on the occurence of bytes) and then encodes the target data using this tree.
Huffman has a time complexity of O(n log n)
The space complexity of this is log n
* Huffman Compression Algorithm [here](../main/huffman-compression/Huffman.java)


### Dynamic Programming
#### Fibonacci
Implements a dynamic and recursive fibonacci algorithm.
The time complexity of the recursive is O(n^2)
The time complexity of the dynamic is O(n)
The space complexity of the recursive is 1
The space complexity of the dynamic is n.
#### Knapsack Problem
The knapsack problem is a optimization problem which maximises value while constraining to the maximum weight of a 'sack'
The time complexity of this algorithm is nw where n is input size and w is the permutation of weights.
The space complexity of this algorithm is n.
* Dynamic Programing Algorithms [here](../main/dyanmic-programing/src/main.java)

## Authors

* **Zac Reid** - [zacreid](https://github.com/zacreid)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.


## Acknowledgments

* Algo Repo for COMP20290 - UCD
