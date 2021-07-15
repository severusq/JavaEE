abstract class Shape { //抽象类，不能创建对象，但可以有常规类的任何东西，如果只有抽象函数，用接口更合适
	abstract void draw(); //抽象函数
	void erase() { //非抽象函数
		
	}
}
class Circle extends Shape {
	@Override //注解，相当于标签吧，不是很懂
	void draw() { //继承了抽象类的子类必须要实现所有抽象函数
		System.out.println("Circle.draw()");
	}
	@Override
	void erase() {
		System.out.println("Circle.erase");
	}
	
}
class Square extends Shape {
	@Override
	void draw() {
		System.out.println("Square.draw()");
	}
	@Override
	void erase() {
		System.out.println("Square.erase");
	}
	
}
public class Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] shape = new Shape[3]; //这只是声明，是合法的
		//shape[0] = new Shape(); //这里不合法，因为不可以创建抽象类的实例对象
		int n;
		for (int i = 0; i < shape.length; i++) { //length得到数组的长度，和c++不一样(.length())
			n = (int) (Math.random() * 2);
			switch (n) {
			case 0:
				shape[i] = new Circle();
				break;
			case 1:
				shape[i] = new Square();
				break;
			}
		}
		for (Shape one: shape) {
			one.draw(); //动态绑定，这里不用抽象类也是一样的，运行的时候决定调用谁的draw函数
			one.erase();
		}
	}

}
