/*
 * main.cpp
 *
 *  Created on: 2017年9月11日
 *      Author: 死神柯南
 */
#include "A.h"
#include <iostream>

int main()
{
	printf("Before entering the tree.\n");
	A a(0);
	A aa(10);
	a.i = 10;
	printf("&a=%p\n", &a);
	printf("&a.i=%p\n", &(a.i));
	a.f();
	printf("&aa=%p\n", &aa);
	aa.i = 30;
	aa.f();
	printf("Before closing the tree.\n");
	printf("aa.i=%d\n", aa.i);

	printf("After closing the tree.\n");
	return 0;
}
