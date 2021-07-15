/*
 * main.cpp
 *
 *  Created on: 2018年2月3日
 *      Author: 死神柯南
 */

#include "TicketMachine.h"
int main()
{
	TicketMachine tm(100 ,100);
	tm.insertMoney(100);
	tm.showBalance();
	return 0;
}


