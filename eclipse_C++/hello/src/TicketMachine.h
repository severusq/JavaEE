/*
 * TicketMachine.h
 *
 *  Created on: 2017年9月9日
 *      Author: 死神柯南
 */

#ifndef TICKETMACHINE_H_
#define TICKETMACHINE_H_

class TicketMachine {
public:
	TicketMachine();
	virtual ~TicketMachine();
	void showPrompt();
	void insertMoney(int money);
	void showBalance();
	void printTicket();
	void showTotal();
private:
	const int PRICE;
	int balance;
	int total;
};

#endif /* TICKETMACHINE_H_ */
