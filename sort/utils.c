/*
 * swap.c
 *
 *  Created on: Aug 10, 2016
 *      Author: wenjian
 */
/**
 * swap the two value
 */
#include<stdio.h>
#include "several_algs.h"

void swap(int* a, int* b){
	int tmp = 0;
	tmp = *a;
	*a = *b;
	*b = tmp;
}

void print(char* str, int ori_array[], int n){
	int i=0;
	printf("%s: ", str);
	for(i=0; i<n; i++)
		printf("%d ", ori_array[i]);
	printf("\n");
}
