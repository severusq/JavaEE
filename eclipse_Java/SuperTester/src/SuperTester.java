
class A { //所有的类都继承自Object类
	static int x = 2;
	public void setx(int i) {
		x = i;
	}
	void printa() {
		System.out.println(x);
	}
}

final class B extends A { //继承，用法同c++,final表示不能有子类，final函数表示子类不可以重载它
	int x = 100; //覆盖父类的x
	void printb() { //不能继承父类的静态数据，但可以修改它
		super.x += 10; //通过super访问父类的数据域，访问被覆盖的父类方法也是一样
		System.out.println("super.x = " + super.x);
	}
}

public class SuperTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A();
		a1.setx(4);
		B b1 = new B();
		b1.printa();
		b1.printb();
	}

}
