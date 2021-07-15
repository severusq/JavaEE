enum Grade {
	VIP,
	GENERAL;
}

class BankAccount {
	private String ownerName;
	private static int LAST_ACCOUNT_NUMBER = 0; //计数器，每次创建一个对象就+1
	private int accountNumber;
	private float balance;
	Grade grade;
	public BankAccount() {
		this("", 0, 0, Grade.GENERAL); //this函数调用下面的构造函数
	}
	public BankAccount(String initName, int initAccNum, float initBal, Grade g) {
		ownerName = initName;
		accountNumber = ++LAST_ACCOUNT_NUMBER;
		balance = initBal;
		grade = g;
	}
	public String getownerName() {
		return ownerName;
	}
	public int getAccounNumber() {
		return accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setOwnerName(String newName) {
		ownerName = newName;
	}
	public void setAccountNumber(int newNum) {
		accountNumber = newNum;
	}
	public void setBalance(float newBalance) {
		balance = newBalance;
	}
	public void setGrade(Grade g) {
		grade = g;
	}
	public String toString() { //重载toString函数，必须是public String toString() {...}且不要使用System.out.println
		return (grade + "account #" + new java.text.DecimalFormat("000000").format(accountNumber) 
				+ " with balance " + new java.text.DecimalFormat("$0.00").format(balance)); //设定格式化输出
	}
	public static BankAccount example1() { //返回类实例，作用是生成几种特殊的账号样例
		BankAccount ba = new BankAccount();
		//ba.setAccountNumber(55400);
		ba.setBalance(1000);
		ba.setGrade(Grade.GENERAL);
		ba.setOwnerName("LiHong");
		return ba;
	}
}

public class AccountTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount bobsAccount, maryAccount;
		bobsAccount = new BankAccount();
		maryAccount = BankAccount.example1(); //调用构造特殊用例的静态函数
		System.out.println(bobsAccount); //调用toString函数，有默认的，这里重写了
		System.out.println(maryAccount);
	}

}
