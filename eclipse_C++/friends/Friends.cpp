/*
 * Friends.cpp
 *
 *  Created on: 2017年9月11日
 *      Author: 死神柯南
 */

struct X;

struct Y {
	void f(X*);
};

struct X {
private:
	int i;
public:
	void initiatize();
	friend void g(X*, int);
	friend void Y::f(X*);
	friend struct Z;
	friend void h();
};

void X::initiatize()
{
	i = 0;
}

void g(X *x, int i)
{
	x->i = i;
}

void Y::f(X *x)
{
	x->i = 47;
}

struct Z {
private:
	int j;

};

int main()
{
	return 0;
}
