enum Grade {
	VIP,
	GENERAL;
}

class BankAccount {
	private String ownerName;
	private static int LAST_ACCOUNT_NUMBER = 0; //��������ÿ�δ���һ�������+1
	private int accountNumber;
	private float balance;
	Grade grade;
	public BankAccount() {
		this("", 0, 0, Grade.GENERAL); //this������������Ĺ��캯��
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
	public String toString() { //����toString������������public String toString() {...}�Ҳ�Ҫʹ��System.out.println
		return (grade + "account #" + new java.text.DecimalFormat("000000").format(accountNumber) 
				+ " with balance " + new java.text.DecimalFormat("$0.00").format(balance)); //�趨��ʽ�����
	}
	public static BankAccount example1() { //������ʵ�������������ɼ���������˺�����
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
		maryAccount = BankAccount.example1(); //���ù������������ľ�̬����
		System.out.println(bobsAccount); //����toString��������Ĭ�ϵģ�������д��
		System.out.println(maryAccount);
	}

}
