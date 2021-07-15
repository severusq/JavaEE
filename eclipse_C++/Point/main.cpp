/*
 * main.cpp
 *
 *  Created on: 2017年9月11日
 *      Author: 死神柯南
 */


#include <iostream>
#include <cstdio>
using namespace std;

class B {
public:
	B(int i) {}
	B() {}
};
//class Point{
//	private:      //Indispensable, default
//		int i;
//		int *q;
//		B b;
//	public:
//		Point():q(0), i(0){ b = 0; cout << "Point::Point()" << endl; }
//		~Point() { if (q) delete q; cout << "Point::~Point(),i=" << i << endl; }
//		void set(int i) { this->i = i;}
//		void f() { q = new int; cout << "Hello." << endl; }
//		void g(Point *nq) {cout << "A::g(),nq->i=" << nq->i << endl;
//		}
//};
struct Point{
	int i;
	int *q;
	B b;
public:
	Point():i(0), q(0), b(0){ cout << "Point::Point()" << endl; }
	~Point() { if (q) delete q; cout << "Point::~Point(),i=" << i << endl; }
	void set(int i) { this->i = i;}
	void f() { q = new int; cout << "Hello." << endl; }
	void g(Point *nq) {cout << "A::g(),nq->i=" << nq->i << endl;
	}
};
struct X {
public:          //Indispensable, default
	int i;
	int j;
};
int main()
{
	Point *p = new Point[10];
	for (int i = 0; i < 10; i++)
	{
		p[i].set(i);
	}
	int *a = 0;
	delete a;
	Point b;
	b.set(100);
	p[0].g(&b);
	delete[] p;
}
