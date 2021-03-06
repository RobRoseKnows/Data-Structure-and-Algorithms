/*
 * stack.h
 *
 *  Created on: Aug 14, 2016
 *      Author: wenjian
 */

#ifndef STACK_H_
#define STACK_H_

#define INIT_CAPACITY 10

struct Stack{
	int *data;
	int stack_size;
	int top;
};
void init_stack(struct Stack* s);
void push(struct Stack* s, int e);
int pop(struct Stack* s);
int stack_peek(struct Stack* s);
#endif /* STACK_H_ */
