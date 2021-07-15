interface Shape {
	final double pi = 3.14; //接口数据成员默认final，可以省略，且必须要初始化且不能被改变
}

interface Shape2D extends Shape { //接口可以实现多继承
	public abstract double area(); //函数默认public abstract，也可以省略
}

interface Color {
	void setColor(String str); //函数必须是抽象函数
}

class Circle implements Shape2D, Color { //实现两个接口的实例
	double radius;
	String color;
	public Circle(double r) {
		radius = r;
	}
	public double area() { //实现一个接口的类还要实现它的父接口的类，这里没有
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
		Employee emp = man; //塑形，子类会自动塑形为父类或接口或塑形回来
		//emp.getSalary(); //出错，emp被当成Employee类，不能用这个函数
		Manager man1 = (Manager)emp; //塑形回原本的类
		man1.getSalary();
		System.out.println(man1.equals(man)); //true，他们是同一个对象，==和euqals都判断是不是同一个对象
		System.out.println(emp == man); //true，塑形只是当做是另一个对象，实际上没有改变对象类型
		emp.Pay(); //调用Manager类的函数，总是从原始类开始向上查找，首先在它本来的Manager类查找
		emp.expense(); //静态函数查找在编译时进行，由于声明时Employee类，所以会调用Employee的函数
	}

}
