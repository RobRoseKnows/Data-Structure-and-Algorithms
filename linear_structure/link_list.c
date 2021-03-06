/*
 * link_list.c
 *
 *  Created on: Aug 14, 2016
 *      Author: wenjian
 */
#include <stdlib.h>
#include <stdio.h>
#include "link_list.h"

/**
 * create link list, this link is cycle unidirect link list
 * input: array, and the length of array
 * out put, the head link
 */
struct LNode* create_link_list(int array[], int n){
	struct LNode* head = (struct LNode*)malloc(sizeof(struct LNode));
	struct LNode* p = head;
	int i = 0;
	for(i=0; i<n; i++){
		p->data = array[i];
		if(i < n-1){
			p->next = (struct LNode*)malloc(sizeof(struct LNode)); /*malloc memory space to a new node*/
			p = p->next;
		}
		else
			p->next = head;/*finally not malloc a new node, but just point to the head*/
	}

	return head;
}
