
class A { //���е��඼�̳���Object��
	static int x = 2;
	public void setx(int i) {
		x = i;
	}
	void printa() {
		System.out.println(x);
	}
}

final class B extends A { //�̳У��÷�ͬc++,final��ʾ���������࣬final������ʾ���಻����������
	int x = 100; //���Ǹ����x
	void printb() { //���ܼ̳и���ľ�̬���ݣ��������޸���
		super.x += 10; //ͨ��super���ʸ���������򣬷��ʱ����ǵĸ��෽��Ҳ��һ��
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
