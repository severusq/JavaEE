/*
 * main.cpp
 *
 *  Created on: 2018��2��3��
 *      Author: �������
 */

#include <iostream>
using namespace std;

class A{
private:
	int i;
	int k;
public:
	void f();
};

void A::f()
{
	int j = 10;
	i = 10;
	cout << &i << " " << &k <<" " << &j << endl;
}

int main()
{
	A a;
	A b;
	a.f();
	b = a;
	b.f();
	return 0;
}

class A {
private:
	int i;
public:
	A() { i = 0; cout << "A::A()" << endl; }
	~A() { cout << "A::~A(), i = " << i << endl; }
	void set(int i) { this->i = i; }
	void f() { cout << "Hello" << endl; }
};

int main()
{
	A* p = new A[10];
	for( int i = 0; i < 10; i++)
	{
		p[i].set(i);
	}
	delete [] p;

	return 0;
}

struct X;

struct Y {
	void f(X* );
};

struct X {
private:
	int i;
public:
	void initialize();
	friend void g(X*, int);
	friend void Y::f(X*);
	friend struct Z;
	friend void h();
	void F(X* x) { x->i = 10; }
};

void X::initialize()
{
	i = 0;
}

void g(X* x, int i)
{
	x->i = i;
}

void Y::f(X* x)
{
	x->i = 47;
}

int main()
{
	return 0;
}

class A {
public:
	A(int ii): i(ii) { cout << "A::A()" << endl; } // ��Ա��������д����inline
	~A() { cout << "A::~A()" << endl; }
	void print() { cout << "A::f() " << i << endl; }
	void print(int ii) { i = ii; }
protected:
	void set (int ii) { i = ii; }
private:
	int i;
};

class B : public A {
public:
	B() : A(15) { }
	~B() { cout << "B::~B()" << endl; }
	void f() {
		set(20);
//		i = 30;
		print();
	}
	void print() { cout << "B::B()" << endl; }
};

int main()
{
	B b;
//	b.set(10);
	b.print();
	b.f();
//	b.print(200);//������overloaded������������������ֻ��������һ������
	b.A::print(200);
	b.B::print();

	return 0;
}

class Employee {
public:
	Employee( const std::string& name, const std::string& ssn);
	const std::string& get_name() const;//const���߱������˺��������޸��κγ�Ա����
	void print(std::ostream& out) const;
	void print(std::ostream& out, const std::string& msg) const;
protected:
	std::string m_name;
	std::string m_ssn;
};

class Manager : public Employee {
public:
	Manager(const std::string& name, const std::string& ssn, const std::string& title);
	const std::string title_name() const;
	const std::string& get_title() const;
	void print(std::ostream& out) const;
private:
	std::string m_title;
};

Employee::Employee( const std::string& name, const std::string& ssn ) : m_name(name), m_ssn(ssn)
{

}
inline const std::string& Employee::get_name() const //inline������.h���棬�Կռ任ʱ��
{
	return m_name;
}

inline void Employee::print( std::ostream& out ) const
{
	out << m_name << std::endl;
	out << m_ssn << std::endl;
}

inline void Employee::print( std::ostream& out, const std::string& msg) const
{
	out << msg << std::endl;
	print(out);
}

Manager::Manager( const std::string& name, const std::string& ssn, const std::string& title = "")
: Employee(name, ssn), m_title(title)
{

}
inline void Manager::print( std::ostream& out ) const{
	Employee::print(out);
	out << m_title << std::endl;
}

inline const std::string& Manager::get_title() const {
	return m_title;
}

inline const std::string Manager::title_name() const {
	return std::string( m_title + ": " + m_name);
}

int main()
{
	Employee bob("Bob Jones", "555-44-0000");
	Manager bill("Bill Smith", "666-33-1234");
	std::string name = bill.get_name();
	std::cout << bill.title_name() << '\n' << std::endl;
	bill.print(std::cout);
	bob.print(std::cout);
	bob.print(std::cout, "Employee:");
	int x;
	std::cin >> x;
//	const int size = x;
//	int* p = new int [size];

	return 0;
}

using namespace std;

class A {
	const int i;
public:
	A(): i(0) {}
	void f() { cout << "f()" << endl; }
	void f() const { cout << "f() const" << endl; }
};

int main()
{
	A a;
	a.f();

	return 0;
}

int x = 9;

int& h()
{
	int q = 0;
	return x;
}

int main()
{
	int a = h();
	h() = 12;
	int y;
	int& aa = x;
	int& b = y;
	b= aa;//reference����ָ�������Ķ��󣬱��뱻��ʼ�������ܱ����ʵ�ַ��û��reference��reference
	cout << a << endl;
	cout << x << endl;
	return 0;
}

class A {
public:
	int i;
	A() : i(10) {}
};

class B : public A {
private:
	int j;
public:
	B() : j(30) {}
	void f() { cout << "b.j = " << j << endl; }
};

int main()
{
	A a;
	B b;

	cout << a.i << " " << b.i << endl;
	cout << sizeof(a) << " " << sizeof(b) << endl;
	int *p = (int *)&a;
	cout << p << " " << *p << endl;
	*p = 20;
	cout << a.i << endl;
	p = (int *)&b;
	cout << p << " " << *p << endl;
	p++;
	*p = 50;
	b.f();

	A* q = b;//upcasting
	A &qq = b;//upcasting

	return 0;
}

class A {
public:
	A() : i(10) {}
	virtual ~A() {};
	virtual void f() { cout << "A::f()" << i << endl; }
	virtual void h() { cout << "A::h()" << endl; }
	virtual void h(int ) { cout << "A::h(int)" << endl; }
	void g() {}
	int i;
};

class B: public A {
public:
	B() : j(20) {}
	virtual ~B() {};
	virtual void f() {  A::f(); cout << "B::()" << j << endl; }
	virtual void h() { cout << "B::h()" << endl; }
	virtual void h(int ) { cout << "B::h(int)" << endl; }
	int j;
};

int main()
{
	A a;
//	A b;
	B b;
	a.f();
//	cout << sizeof(a) << endl;
//	int *p = (int *)&a;
//	int *q = (int *)&b;
//	(*p)++;
//	int *x = (int*)*q;
//	cout << *p << *q << endl;
//	cout << x << endl;
	A *p = &b;
	p->f();
	a = b;
	a.f();
	p = &a;
	p->f();
	int *t = (int*)&a;
	int *r = (int*)&b;
	cout << r << " " << t << endl;
	++r; ++t;
	b.i = 30;
	cout << *r << " " << *t << endl;
	--r; --t;
	*t = *r;
	p->f();

	cout << a.i << endl;
	b.h();
	b.h(3);
	b.A::h();
	b.A::h(1);

	return 0;
}

class A {
public:
	int i;
	A() : i(0) {}
};

A f()
{
	A a;
	return a;
}
void f(const int &i)
{
	cout << i << endl;
}

int main()
{
	int i = 3;
	f(i*3);
//	f().i = 10;//��֪��Ϊʲô������

	return 0;
}

static int objectCount = 0;

class HowMany {
public:
	HowMany() { objectCount++; print("HowMany()"); }
	HowMany(int i) { objectCount++; print("HowMany(int)"); }
	HowMany(const HowMany &o) {objectCount++; print("HowMan(HM)"); }//��������
	void print(const string& msg = "") {
		if(msg.size() != 0) cout << msg << ": ";
		cout << "objectCount = " << objectCount << endl;
	}
	~HowMany() {
		objectCount--;
		print("~HowMany");
	}
};

HowMany f(HowMany x)
{
	cout << "begin of f" << endl;
	x.print("x argument inside f()");
	cout << "end of f" << endl;

	return x;
}

int main()
{
	HowMany h;
	h.print("after construction of f");
	HowMany h3 = 10;
	HowMany h2 = f(h);
	h.print("after call to f");

	return 0;
}

#include <cstring>

class Person {
public:
	Person(const char *s) { printf("Person()\n"); name = new char[::strlen(s) + 1];
	::strcpy(name, s);
	}
	Person(const Person& w) { printf("Person(const Person& w)\n"); name = new char[::strlen(w.name) +1];
	::strcpy(name, w.name);
	}
	~Person() { printf("~Person()\n"); delete [] name; }
	void print() {};

	char *name;
};

Person copy_func(const char *who)
{
	printf("inside copy_func()\n");
	Person local(who);
	local.print();
	return local;
}

Person nocopy_func(const char *who)
{
	printf("inside nocopy_func()\n");
	return Person(who);
}
int main()
{
	int i(4);
	Person p1("John");
	Person p2(p1);
//	cout << "p1.name=" << &p1.name << endl;
//	cout << "p2.name=" << &p2.name << endl;
	Person p3 = copy_func("x");
	printf("after p3\n");
	Person p4 = nocopy_func("x");
	printf("p1.name=%p, p2.name=%p, p3.name=%p, p4.name=%p\n", p1.name, p2.name, p3.name, p4.name);

	return 0;
}

class A {
public:
	A() { i = 0; }//��̬��Ա�������ܷ��ڳ�ʼ���б�����
	void print() {cout << i << endl; }
	void set(int i) { this->i = i; }
	static void say(int ii) { cout << ii << i << endl; }//���ܷ��ʷǾ�̬������û��thisָ��
private:
	int k;
	static int i;
};

int A::i = 20;//���ܼ�static,��������Υ��

int main()
{
	A a, b;
	a.set(10);
	b.print();
	a.say(10);
	A::say(10);
//	cout << a.i << endl;
//	cout << A::i << endl;

	return 0;
}

class Integer {
public:
	Integer(int n = 0) : i(n) {}
	const Integer operator+(const Integer& n) const { //����ֵҲ������const����������ֵ
		return Integer(i + n.i);                      //�����µ�integer�Ķ���
	}      											  //������ÿ������죬��������������ʹ����������������Ż�
	friend const Integer operator*(const Integer& lhs, const Integer& rhs);
	//private:
	int i;
};

const Integer operator*(const Integer& lhs, const Integer& rhs) {
	return Integer(lhs.i * rhs.i);
}

int main()
{
	Integer x(1), y(5), z;
	z = x + y; //z = x.operator+(y);"+"��ߵ���receiver���������ĸ���+��
	z = z.operator +(3);
//	z = 3 + z;//��Ա����������
	z = y * z;
	z = 3 * z;//ȫ�ֺ�����ʱ�����������
	z = 3 + 7;
	cout << z.i << endl;

	return 0;
}

#include <cstring>
class A {
	char *p;
	A& operator=(const A& that)
	{
		delete p;
		if(p != that.p)//һ��Ҫ������жϷ���delete p֮��that pҲû��
			{
				p = new char [strlen(that.p) + 1];
				strcpy(p, that.p);
			}
		return *this;
	}
};

class Cargo {
public:
	Cargo& operator=(const Cargo&) {
		cout << "inside Cargo::operator=()" << endl;
		return *this;
	}
};

class Trunk {
	Cargo b;
};

int main()
{
	Trunk a, b;
	a = b;
	return 0;
}

class One {
public:
	One() {}
};

class Two {
public:
//	Two(const One&) {}//�����Զ���Oneת��ΪTwo����
	explicit Two(const One&) {}//���߱����������Զ�ת������������д����
};

void f(Two) {}

int main()
{
	One one;
//	f(one); //����������Two�Ĺ��캯�������һ��two�ٽ���f
	f(Two(one));//OK

	return 0;
}


class Orange;

class Apple {
public:
	operator Orange() const{...};
};

class Orange {
public:
	explicit Orange(Apple) {...};//�������
};

void f(Orange) {}

int main()
{
	Apple a;
	f(a); //���ַ�ʽû�����ȼ�������

	return 0;
}

template <class T>
class Vector {
public:
	Vector(int);
	~Vector() {};
//	Vector(const Vector);
	Vector& operator=(const Vector);
	T& operator[](int);
private:
	T* m_elements;
	int m_size;
};

template <class T>
Vector<T>::Vector(int size) : m_size(size) {
	m_elements = new T[m_size];
}
template <class T>
T& Vector<T>::operator [](int index) {
	if(index < m_size && index > 0) {
		cout << m_elements[index];
		return m_elements[index];
	}
	else {

	}
}

template <class T>
void swap_0(T& x, T& y) {
	T temp = x;
	x = y;
	y = temp;
	cout << x << y << endl;
	cout << "Completed!" << endl;
}

template <class T>
void sort(Vector<T>& arr)
{
	const size_t last = arr.size()-1;
	for (int i = 0; i < last; i++)
	{
		for (int j = last; i < j; j--)
		{
			if (arr[j] < arr[j - 1]);
			swap_0(arr[j], arr[j - 1]);
		}
	}
}
int main()
{
	Vector<int> v1(100);
//	Vector<complex> v2(256);
	v1[20] = 10;
	Vector<int> vi(4);
	vi[0] = 4; vi[1] = 3; vi[2] = 7; vi[3] = 1;
	sort(vi);
	Vector<string> vs;
	vs.push_back("Fred");
	vs.push_back("Wilma");
	sort(vs);

	return 0;
}

void swap_0(int i, int j) //ò�Ʋ�����std�����swap����
{
	int temp = i;
	i = j;
	j = temp;
	cout << i <<" " << j << endl;
}
template <class T>
void swap_0(T& x, T& y) {
	T temp = x;
	x = y;
	y = temp;
//	cout << x << y << endl;
//	cout << "Completed!" << endl;
}

int main()
{
	int i = 3, j = 4;
	swap_0(i, j);
	float k = 4.5, m = 3.7;
	swap_0(k, m);
	string s("Hello");
	string t("World");
	swap_0(s, t);

	return 0;
}

template <class T>
void foo(void) {}
int main()
{
	foo<int>();//��һ��int��foo������
	foo<float>();//��һ��float��foo������ȥ�����foo
	return 0;
}

template<class Key, class Value>//��ϣ��
class HashTable {
	const Value& lokkup(const Key&)const;
	void install(const Key&, const Value&);
};

Vector<Vector<double *> >//> >�ӿո�
Vector<int (*)(Vector<double>&, int)>//�����Ǹ�����ָ��
template <class T, int bounds = 100>//default value

class VectorIndexError {
public:
	VectorIndexError(int v) : m_badValue(v) {
		~VectorIndexError() {}
		void diagnostic() {
			cerr << "index" << m_badValue << "out of range!";
	}
	private:
		int m_badValue;
};

template <class T>
T& Vector<T>::operator[](int indx) {
	if(indx < 0 || indx >= m_size)
	{
		throw VectorIndexError(indx);
	}
	return m_elements[indx];//�ں����ڲ������Ķ����ڶ���
}

void outer()
{
	try
	{
		func(); func();//���������еڶ���func
	}
	catch(VectorIndexError& e)//�����ﱻ����
	{
		e.diagnostic();
	}
	cout << "control ia here after exception";
}

void outer2()
{
	string err("exception caught");
	try
	{
		func();
	}
	catch(VectorIndexError)
	{
		cout << err;
		throw;//�ø��߼���Ķ����������Ѹո�׽���Ķ����ӳ�ȥ������try�൱��throw
	}
}

void outer3()
{
	try
	{
		outer2();
	}
	catch(...)//���������쳣���ò��������������֮��
	{
		cout << "The exception stops here";
	}
}

int func()
{
	Vector<int> v(12);
	v[3] = 5;
	int i = v[42];//�൱��throw��䣬�ص��������ĵط�
	return i*5;
}

class MathErr {
	virtual void diagnostic();
	virtual ~MathErr() {}
};

class OverflowErr : public MathErr {};
class UnderflowErr : public MathErr {};
class ZeroDivideErr : public MathErr {};

int main()
{

	try
	{
		throw UnderflowErr();
	}
	catch (ZeroDivideErr& e){}//��˳��һ������������������һ���������ɣ�׼ȷ�ģ��и������catch�ģ�...
	catch (MathErr& e) {}//��������
	catch (UnderflowErr& e) {}//��Զ�������������������
	catch (...) {};
}

void abc(int a) : throw(MathErr) {}//ֻ�����׳�����쳣

void func()
{
	try
	{
		while(1)
		{
			char *p = new char[1000];
		}
	}
	catch(bad_alloc& e)//new�����ķ���ֵ����NULL������bad_alloc
	{

	}
}

Printer::print(Document&) : throw(PrinterOffine, BadDocument) {}//ֻ�����׳��������쳣
PrinterManager::Print(Document&) : throw(BadDocument) {}//ֻ�����׳�����쳣
void goodguy() : throw() {}//ʲô������
void average() {}//ʲô�����ף�Ҳ�������

class A {
public:
	A() {//���캯�������⣬
		buf = new char[1024];
		delete this;//һ�ֽ������������û�����ջؿռ���
		throw 0;//�ڹ��캯����throw�з��գ��׳��쳣��ζ�Ź���û����ɣ����Ҳ����������������Ҳ��һ�����õ�����
	}
	~A() { delete buf; }//��Ϊ�������������Բ����ڴ�����
};

int notmain()
{
	A *p = new A();//�ȷ����ڴ棬�ٹ���
	delete p;//��֪��������
	return 0;
}

try
{
	throw new Y();
}
catch(Y* p)
{
	//������ɾ�����p����������ڴ�����
}

#include <vector>

int main()
{
	vector<int> x;
	for(int a = 0; a < 100; a++)
	{
		x.push_back(a);
	}
	vector<int>::iterator p;
	for(p = x.begin(); p < x.end(); p++)
		cout << *p << " ";

	return 0;
}

#include <list>
#include <string>

int main()
{
	list<string> s;
	s.push_back("Hello");
	s.push_back("world");
	s.push_front("tide");
	s.push_front("crimson");
	s.push_front("alabama");
	list<string>::iterator p;
	for(p = s.begin(); p != s.end(); p++)
	{
		cout << *p << " ";
	}
	return 0;
}

#include <map>
#include <string>

int main()
{
	map<string, float> price;
	price["snapple"] = 0.75;
	price["coke"] = 0.50;
	string item;
	double total = 0;
	while(cin >> item)
	{
		total += price[item];
		cout << total << endl;
	}

	cout << "notOK";
	cout << total << "completed";

	return 0;
}