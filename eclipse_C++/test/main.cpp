/*
 * main.cpp
 *
 *  Created on: 2017年9月11日
 *      Author: 死神柯南
 */


#include <iostream>
#include <stdio.h>
#include <cstdlib>

using namespace std;

class A {
public:
	int i;
	A(int initi);
	int j;
	void f(int i);
	~A();
};

A::~A()
{
	printf("Inside the destructor.\n");
}

A::A(int initi)
{
	i = initi;
	printf("i=%d,A::A()--this=%p\n", i, this);
}

void A::f(int i)
{
	/*if(i < 10)
	{
		goto jump1;
	}
	A a1(2);
	jump1:
	switch(i)
	{
	case 1:
		A a2(1); break;
	case 2:
		A a3(3); break;
	}
	this->i = 20;
	printf("i=%d\n", i);
	printf("A::f()--&i=%p, &j=%p\n", &i, &j);
	printf("this=%p\n", this);*/
}


int main()
{
	printf("Before entering the tree.\n");

	A a(4);

	a.i = 10;
	A aa(10);
	a.f(1);
	/*printf("&a=%p\n", &a);
	printf("&a.i=%p\n", &(a.i));
	a.f();
	printf("&aa=%p\n", &aa);
	aa.i = 30;
	aa.f();
	printf("Before closing the tree.\n");
	printf("aa.i=%d\n", aa.i);*/
	printf("After closing the tree.\n");
	return 0;
}
