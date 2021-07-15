/*
 * A.cpp
 *
 *  Created on: 2017年9月11日
 *      Author: 死神柯南
 */

#include "A.h"
#include <iostream>

using namespace std;

A::A(int initi) {
	// TODO Auto-generated constructor stub
	i = initi;
	j = initi;
	printf("i=%d,A::A()--this=%p\n", i, this);

}

A::~A() {
	// TODO Auto-generated destructor stub
	printf("Inside the destructor.\n");
}

void A::f()
{
	this->i = 20;
	printf("i=%d\n", i);
	printf("A::f()--&i=%p, &j=%p\n", &i, &j);
	printf("this=%p\n", this);
}
