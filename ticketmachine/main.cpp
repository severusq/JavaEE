/*
 * main.cpp
 *
 *  Created on: 2018��2��3��
 *      Author: �������
 */

#include "TicketMachine.h"
int main()
{
	TicketMachine tm(100 ,100);
	tm.insertMoney(100);
	tm.showBalance();
	return 0;
}


