/*
 * TicketMachine.cpp
 *
 *  Created on: 2018��2��3��
 *      Author: �������
 */

#include "TicketMachine.h"

#include <iostream>
using namespace std;
TicketMachine::TicketMachine(int j, int k): PRICE(100) {
	// TODO Auto-generated constructor stub
	balance = j;
	total = k;
	cout << "Inside the TicketMachine()" << endl;

}

TicketMachine::~TicketMachine() {
	// TODO Auto-generated destructor stub
	cout << "Inside the ~TicketMachine()" << endl;
}


void TicketMachine::showPrompt() {
	cout << "something" << endl;
}

void showPrompt()
{
	cout << "anything" << endl;
}

void TicketMachine::insertMoney(int money) {
	balance += money;
	showPrompt();
}

void TicketMachine::showBalance() {
	cout << balance << endl;
}
