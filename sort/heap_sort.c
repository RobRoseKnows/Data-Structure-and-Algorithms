/*
 * heap_sort.c
 *
 *  Created on: Aug 11, 2016
 *      Author: wenjian
 */

/**
 *heap sort analysis
 *unstable
 *time: worst, O(nlogn); average, O(nlogn); best, O(nlogn)
 *auxiliary: O(1)
 */
/**
 * parent(i)/left(i)/right(i)
 * all the index start from 0
 * max heap: parent node >= child node for all the binary tree and sub binary tree
 * and it is complete binary
 * parent of i-th node is (i-1)/2, and child of i-th node is 2*i+1 and 2*i+2
 * assume i-th node i on j-th level and k-th position, so i=2^(j-1)+k-1;
 * the last one of j-th level is 2^(j-1)+2^(j-1)-2
 * for the (j+1)-th level, from there are 2*[(k+1)-1] nodes
 * => the left child is [2^(j-1)+2^(j-1)-2] + 2*k + 1 = 2*[2^(j-1)+k]-1 = 2*i+1;
 * => right child 2*i+2;
 * => parent node (i-1)/2
 */
/**
 * leaf node from n/2
 * the node number of 0 child, 1 child and 2 child is n0, n1 and n2 => n0+n1+n2=n
 * also, the child number is n1+2*n2, and n1+2*n2+1=n
 * =>n0=(n+1-n1)/2, so the index of leaf node is n-[(n+1-n1)/2]=(n-1+n1)/2, and n1=0 or 1
 * =>the index is (n-1)/2 or n/2 if n1=0 or 1
 * n1=0 means n=odd and n1=1 means n=even
 * =>we just can say index of leaf is n/2 whatever n=odd or even
 */
#include"several_algs.h"

static void max_heap_recu(int ori_array[], int i, int n){
	int largest=i; //assume the i-th is the largest
	int left=2*i+1;
	int right=2*i+2; //left and right position
	if((left < n) && (ori_array[left] > ori_array[i]))
		largest = left;
	if((right < n) &&(ori_array[right] > ori_array[largest]))
		largest = right;
	if(largest != i){
		swap(&ori_array[i], &ori_array[largest]);
		max_heap_recu(ori_array, largest, n);// keep max heap
	}
}
int heap_sort(int ori_array[], int n){
	int i=0;
	for(i=n/2-1; i>=0; i--)
		max_heap_recu(ori_array, i, n); //get the max heap from i --> n, and 0-th is maximum

	for(i=n-1; i>=0; i--){
		swap(&ori_array[0], &ori_array[i]);//get the maximum to the last one
		max_heap_recu(ori_array, 0, i-1);//keep the max heap from 0 --> i-1, i --> n is ordered
	}
	return OK;
}
