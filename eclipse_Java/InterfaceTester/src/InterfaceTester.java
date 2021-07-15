interface Shape {
	final double pi = 3.14; //�ӿ����ݳ�ԱĬ��final������ʡ�ԣ��ұ���Ҫ��ʼ���Ҳ��ܱ��ı�
}

interface Shape2D extends Shape { //�ӿڿ���ʵ�ֶ�̳�
	public abstract double area(); //����Ĭ��public abstract��Ҳ����ʡ��
}

interface Color {
	void setColor(String str); //���������ǳ�����
}

class Circle implements Shape2D, Color { //ʵ�������ӿڵ�ʵ��
	double radius;
	String color;
	public Circle(double r) {
		radius = r;
	}
	public double area() { //ʵ��һ���ӿڵ��໹Ҫʵ�����ĸ��ӿڵ��࣬����û��
		return pi * radius *radius;
	}
	public void setColor(String str) {
		color = str;
	}
}

class Employee {
	void Pay() {
		System.out.println("Employee.Pay()");
	}
	static void expense() {
		System.out.println("Employee.expense");
	}
}
class Manager extends Employee {
	void getSalary() {
		
	}
	void Pay() {
		System.out.println("Manager.Pay()");
	}
	static void expense() {
		System.out.println("Manager.expense");
	}
}
public class InterfaceTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle cir = new Circle(2);
		System.out.println(cir.area());
		
		Manager man = new Manager();
		Employee emp = man; //���Σ�������Զ�����Ϊ�����ӿڻ����λ���
		//emp.getSalary(); //����emp������Employee�࣬�������������
		Manager man1 = (Manager)emp; //���λ�ԭ������
		man1.getSalary();
		System.out.println(man1.equals(man)); //true��������ͬһ������==��euqals���ж��ǲ���ͬһ������
		System.out.println(emp == man); //true������ֻ�ǵ�������һ������ʵ����û�иı��������
		emp.Pay(); //����Manager��ĺ��������Ǵ�ԭʼ�࿪ʼ���ϲ��ң���������������Manager�����
		emp.expense(); //��̬���������ڱ���ʱ���У���������ʱEmployee�࣬���Ի����Employee�ĺ���
	}

}
