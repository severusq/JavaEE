/*
 * TicketMachine.h
 *
 *  Created on: 2018��2��3��
 *      Author: �������
 */

#ifndef TICKETMACHINE_H_
#define TICKETMACHINE_H_

//using namespace std;
class TicketMachine {
public:
	TicketMachine(int j, int k);
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
