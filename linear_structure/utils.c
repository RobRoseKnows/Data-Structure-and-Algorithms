/*
 * utils.c
 *
 *  Created on: Aug 14, 2016
 *      Author: wenjian
 */
#include<stdio.h>
#include"link_list.h"
void print(struct LNode* head){
	struct LNode* p = head;

	while(p->next != head){
		printf("%d ", p->data);
		p = p->next;
	}
	printf("%d ", p->data);
}
