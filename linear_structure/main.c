/*
 * main.c
 *
 *  Created on: Aug 14, 2016
 *      Author: wenjian
 */
#include <stdio.h>
//#include "link_list.h"
//#include "stack.h"
#include "queue.h"
int main(int argc, char* argv[]){
	int array[] = {3,4,22,2,9,34,13,8,18};
	int n = 9;
//	struct LNode* head = create_link_list(array, n);
//	print(head);
//	struct Stack s;
//	struct Queue q;
//	init_stack(&s);
//	init_queue(&q);
	struct DSQueue dsq;

	init_dsqueue(&dsq);

	int i = 0;
	for(i = 0; i<n; i++){
//		push(&s, array[i]);
//		enqueue(&q, array[i]);
		endsqueue(&dsq, array[i]);
	}

	for(i=0; i<n; i++){
//		printf("%d ", pop(&s));

//		printf("%d ", dequeue(&q));
		printf("%d ", dedsqueue(&dsq));
	}
}
