/*
 * TicketMachine.cpp
 *
 *  Created on: 2017年9月9日
 *      Author: 死神柯南
 */

#include "TicketMachine.h"

#include <iostream>
using namespace std;

TicketMachine::TicketMachine() : PRICE(0), balance(0){
	// TODO Auto-generated constructor stub

}

TicketMachine::~TicketMachine() {
	// TODO Auto-generated destructor stub
}

void TicketMachine::showPrompt()
{
	cout << "something";
}

void TicketMachine::insertMoney(int money)
{
	balance += money;
}

void TicketMachine::showBalance()
{
	cout << balance << endl;
}

void TicketMachine::printTicket()
{
	cout << "Ticket." << endl;
}
