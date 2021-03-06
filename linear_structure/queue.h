/*
 * queue.h
 *
 *  Created on: Aug 15, 2016
 *      Author: wenjian
 */

#ifndef QUEUE_H_
#define QUEUE_H_

#include"stack.h"
#define INIT_CAPACITY 10
/*nomal queue structure*/
struct Queue{
	int *data;
	int queue_size;
	int head;
	int rail;
};
/*double stack implement queue*/
struct DSQueue{
	struct Stack s1;
	struct Stack s2;
};

void init_queue(struct Queue* queue);
void enqueue(struct Queue* queue, int e);
int dequeue(struct Queue* queue);
int queue_peek(struct Queue* queue);

void init_dsqueue(struct DSQueue* dsqueue);
void endsqueue(struct DSQueue* dsqueue, int e);
int dedsqueue(struct DSQueue* dsqueue);

#endif /* QUEUE_H_ */
