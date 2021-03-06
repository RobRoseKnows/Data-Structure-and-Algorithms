/*
 * stack.c
 *
 *  Created on: Aug 14, 2016
 *      Author: wenjian
 */

#include<stdlib.h>
#include "stack.h"

void init_stack(struct Stack* s){
	s->data = (int*)malloc(sizeof(int)*INIT_CAPACITY);
	s->stack_size = INIT_CAPACITY;
	s->top = -1;
};

void push(struct Stack* s, int e){
//	if(s->top == s->stack_size-1) increment(s);
	s->data[++s->top] = e;
}

int pop(struct Stack* s){
//	if(s->top == -1) return
	return(s->data[s->top--]);
}

int stack_peek(struct Stack* s){
	return(s->data[s->top]);
}


