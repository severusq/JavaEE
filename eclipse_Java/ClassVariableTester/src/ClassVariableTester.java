//package "my_class";

//import static java.lang.Math.PI; //不加这一行也可以用PI
import static java.lang.Math.*; //静态引入，可以直接用PI不用自己写，还有一些math函数

class Circle { //定义一个类，基本同c++，不用加分号
	static double PI = 3.1415926; //静态变量，成员和类都可以引用并修改还可以初始化，和c++不同
	int radius; //默认的权限是同一包中的所有类都能访问，不管在子类非子类中
	public double area() { //无任何访问限制，定义函数基本同c++
		return PI * radius * radius;
	}
}

class Rectangle{
	double width;
	double height;
	public double area() {
		return width * height;
	}
}

class Converter {
	public static int centigradeToFahrenheit(int cent) { //静态函数，使用同静态变量，访问和c++稍有不同
		return cent * 9/5 + 32;
	}
}

enum Score{ //枚举类型，由枚举值，变量，和函数构成，继承自java.lang.Enum
	EXCELLENT(90.0f), //枚举值，调用构造函数，下同，注意标点符号
	QUALIFIED(70.0f), //枚举值没有public、static、final
	FAILED; //调用无参构造函数
	private float point; //private只有本类中能访问
	Score() { //无参构造函数，自己不写系统会默认生成，好习惯是自己写无参，因为子类初始化默认调用父类无参构造函数
		point = 0.0f;
	}
	private Score(float p) { //枚举构造函数默认private且只能是private
		this.point = p; //this的用法同c++
	}
	float getPoint() { //get和set函数同c++
		return point;
	}
	void setPoint(float point) {
		this.point = point;
	}
}
public class ClassVariableTester { //一个java文件只能有一个public class而且必须和文件名相同，也是一个类
	
	public static void main(String[] args) { //main函数
		// TODO Auto-generated method stub
		Circle x = new Circle(); //声明并用new关键字分配内存
		System.out.println(x.PI); 
		System.out.println(Circle.PI);
		Circle.PI = 3.14;
		System.out.println(x.PI);
		System.out.println(PI + " " + cos(PI/3)); //导入的类中的PI,cos函数来自math类
		
		System.out.println(Converter.centigradeToFahrenheit(40)); //调用静态函数
		
		Circle c = new Circle();
		c.radius = 10;
		Rectangle r1 = new Rectangle();
		r1.width = 20;
		r1.height = 30;
		Rectangle r2 = new Rectangle();
		r2.width = 20;
		r2.height = 20;
		System.out.println("max area of c, r1, r2 is " + maxArea(c, r1, r2));
		
		for (Score s: Score.values()) { //values()把枚举值转换为枚举类型的对象
			System.out.println(s + " " + s.getPoint()); //s是EXCELLENT,QUALIFIED,FAILED
		}
		Score s = Score.FAILED; //把枚举值赋给枚举对象
		s.setPoint(90);
		System.out.println(s.getPoint());
	}

	static double maxArea(Circle c, Rectangle...varRec) {//可变长参数的语法，一个函数最多一个可变长参数而且只能放最后
		double max = 0.0;
		max = c.area();
		Rectangle[] rec = varRec; //用一个数组接收可变长参数
		for(Rectangle r: rec) { //增强for循环，遍历rec并一一赋值给r
			if (r.area() > max)
				max = r.area();
		}
		return max;
	}
}
