abstract class Shape { //�����࣬���ܴ������󣬵������г�������κζ��������ֻ�г��������ýӿڸ�����
	abstract void draw(); //������
	void erase() { //�ǳ�����
		
	}
}
class Circle extends Shape {
	@Override //ע�⣬�൱�ڱ�ǩ�ɣ����Ǻܶ�
	void draw() { //�̳��˳�������������Ҫʵ�����г�����
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
		Shape[] shape = new Shape[3]; //��ֻ���������ǺϷ���
		//shape[0] = new Shape(); //���ﲻ�Ϸ�����Ϊ�����Դ����������ʵ������
		int n;
		for (int i = 0; i < shape.length; i++) { //length�õ�����ĳ��ȣ���c++��һ��(.length())
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
			one.draw(); //��̬�󶨣����ﲻ�ó�����Ҳ��һ���ģ����е�ʱ���������˭��draw����
			one.erase();
		}
	}

}
