//============================================================================
// Name        : hello.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "TicketMachine.h"
using namespace std;

int main() {
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	TicketMachine tm;
	tm.showPrompt();
	tm.showBalance();
	tm.insertMoney(100);
	tm.showBalance();
	tm.printTicket();
	return 0;
}
