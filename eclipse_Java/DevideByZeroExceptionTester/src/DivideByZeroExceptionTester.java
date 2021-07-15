import java.io.*;

class Keyboard {
	static BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
	public static int getInteger() {
		try {
			return (Integer.valueOf(inputStream.readLine().trim()).intValue()); //trim����ȥ�����˿հ�
		}
		catch (Exception e) {
			e.printStackTrace(); //���������ĵ�������
			return 0; //catch��ҲҪд����ֵ
		}
	}
	public static String getString() {
		try {
			return (inputStream.readLine()); //��ȡ����,ò��ɶ������ת�����ַ���
		}
		catch (IOException e) {
			System.out.println(e.getMessage()); //���������쳣���ַ���
			return "0";
		}
		finally {} //������û���쳣��Ҫִ��finally��
	}
}

class DivideByZeroException extends ArithmeticException { //�Զ����쳣�࣬Ҫ�̳�ĳ���쳣��
	public DivideByZeroException() {
		super("Attempted to devide by zero"); //����0�Ƿ�
	}
}

public class DivideByZeroExceptionTester {
	
	private static int quotient(int numerator, int denominator) throws DivideByZeroException { //throws�쳣�����б�
		if (denominator == 0)
			throw new DivideByZeroException(); //throw��try-catch��c++һ��
		return (numerator / denominator);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = 0, number2 = 0, result = 0;
		try {
			number1 = Integer.valueOf(Keyboard.getString()).intValue();
			number2 = Integer.valueOf(Keyboard.getString()).intValue();
			result = quotient(number1, number2);
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid integer entered");
			System.exit(-1); //�˳�ϵͳ
		}
		catch (DivideByZeroException e) {
			System.out.println(e.toString());
			System.exit(-1);
		}
		System.out.println(result);
	}

}
