/*
 * inheritance.cpp
 *
 *  Created on: 2017��9��11��
 *      Author: �������
 */

#include <iostream>
using namespace std;

class A {
private:
	int i;
public:
	A(int ii):i(ii) { cout << "A::A()" << endl; }
	~A() { cout << "A::~A()" << endl; }
//	void print() { cout << "A::f() " << i << endl; }
	void print(int ii) { cout << ii << endl;}
protected:
	void set(int i) { this->i = i; }
};

class B : public A {
public:
//	B() : A(15) { cout << "B::B()" << endl; }
	B() : A(15) { cout << "B::B()" << endl; }   //A::A()�в���ʱ��������һ��
	~B() { cout << "B::~B()" << endl; }
	void print() { cout << "B::print()" << endl; } //ͬ����������������print�����������أ�ֻ��C++��ô��
		void f() {
			set(20);
			print();
//			print(20);
//			i = 30;        //can't do this
	}
};

int main()
{
	B b;
//	b.set(10);
	b.print();
	b.f();
	A a(20);
//	a.i = 10;
	a.print(10);
//	b.i = 30;             //can't do this
	return 0;
}
