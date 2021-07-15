//package "my_class";

//import static java.lang.Math.PI; //������һ��Ҳ������PI
import static java.lang.Math.*; //��̬���룬����ֱ����PI�����Լ�д������һЩmath����

class Circle { //����һ���࣬����ͬc++�����üӷֺ�
	static double PI = 3.1415926; //��̬��������Ա���඼�������ò��޸Ļ����Գ�ʼ������c++��ͬ
	int radius; //Ĭ�ϵ�Ȩ����ͬһ���е������඼�ܷ��ʣ������������������
	public double area() { //���κη������ƣ����庯������ͬc++
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
	public static int centigradeToFahrenheit(int cent) { //��̬������ʹ��ͬ��̬���������ʺ�c++���в�ͬ
		return cent * 9/5 + 32;
	}
}

enum Score{ //ö�����ͣ���ö��ֵ���������ͺ������ɣ��̳���java.lang.Enum
	EXCELLENT(90.0f), //ö��ֵ�����ù��캯������ͬ��ע�������
	QUALIFIED(70.0f), //ö��ֵû��public��static��final
	FAILED; //�����޲ι��캯��
	private float point; //privateֻ�б������ܷ���
	Score() { //�޲ι��캯�����Լ���дϵͳ��Ĭ�����ɣ���ϰ�����Լ�д�޲Σ���Ϊ�����ʼ��Ĭ�ϵ��ø����޲ι��캯��
		point = 0.0f;
	}
	private Score(float p) { //ö�ٹ��캯��Ĭ��private��ֻ����private
		this.point = p; //this���÷�ͬc++
	}
	float getPoint() { //get��set����ͬc++
		return point;
	}
	void setPoint(float point) {
		this.point = point;
	}
}
public class ClassVariableTester { //һ��java�ļ�ֻ����һ��public class���ұ�����ļ�����ͬ��Ҳ��һ����
	
	public static void main(String[] args) { //main����
		// TODO Auto-generated method stub
		Circle x = new Circle(); //��������new�ؼ��ַ����ڴ�
		System.out.println(x.PI); 
		System.out.println(Circle.PI);
		Circle.PI = 3.14;
		System.out.println(x.PI);
		System.out.println(PI + " " + cos(PI/3)); //��������е�PI,cos��������math��
		
		System.out.println(Converter.centigradeToFahrenheit(40)); //���þ�̬����
		
		Circle c = new Circle();
		c.radius = 10;
		Rectangle r1 = new Rectangle();
		r1.width = 20;
		r1.height = 30;
		Rectangle r2 = new Rectangle();
		r2.width = 20;
		r2.height = 20;
		System.out.println("max area of c, r1, r2 is " + maxArea(c, r1, r2));
		
		for (Score s: Score.values()) { //values()��ö��ֵת��Ϊö�����͵Ķ���
			System.out.println(s + " " + s.getPoint()); //s��EXCELLENT,QUALIFIED,FAILED
		}
		Score s = Score.FAILED; //��ö��ֵ����ö�ٶ���
		s.setPoint(90);
		System.out.println(s.getPoint());
	}

	static double maxArea(Circle c, Rectangle...varRec) {//�ɱ䳤�������﷨��һ���������һ���ɱ䳤��������ֻ�ܷ����
		double max = 0.0;
		max = c.area();
		Rectangle[] rec = varRec; //��һ��������տɱ䳤����
		for(Rectangle r: rec) { //��ǿforѭ��������rec��һһ��ֵ��r
			if (r.area() > max)
				max = r.area();
		}
		return max;
	}
}
