/*
 * combination.cpp
 *
 *  Created on: 2017年9月11日
 *      Author: 死神柯南
 */

#include <iostream>
#include <cstring>
using namespace std;
class Person {
public:
	void print();
	Person(const char* name, const char* address) { strcpy(this->name, name); strcpy(this->address, address); }
private:
	char name[20];
	char address[20];
};
class Currency {
public:
	void print();
	Currency(int i, int cents) { cash = i; cent = cents; }
private:
	int cash;
	int cent;
};
class SavingsAccount {
public:
	SavingsAccount(const char *name, const char *address, int cents);
	~SavingsAccount() {};
	void print();
private:
	Person m_saver;
	Currency m_balance;
};

SavingsAccount::SavingsAccount(const char* name, const char* address,
		int cents) : m_saver(name, address), m_balance(0, cents) {}

void SavingsAccount::print()
{
	m_saver.print();
	m_balance.print();
}

void Person::print()
{
	cout << name << "," << address << endl;
}

void Currency::print()
{
	cout << cash << endl;
}
int main()
{
	SavingsAccount account("Jack", "hangzhou", 20);
	account.print();

	return 0;
}
