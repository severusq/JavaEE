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

public class ExceptionTester {
	public static void main(String args[]) {
		int number1 = Keyboard.getInteger();
		System.out.println(number1);
		
		int result = 0;
		int number[] = new int[2]; //����������ͳ�ʼ������֮һ
		for (int i = 0; i < 2; i++) { //������������
			boolean valid = false;
			while (!valid) {
				try {
					number[i] = Integer.valueOf(Keyboard.getString()).intValue(); //�ַ���ת��Ϊ����
					valid = true;
				}
				catch (NumberFormatException e) { //����Ĳ������ֵĴ���
					System.out.println("Invalid input");
					//System.exit(-1);
				}
			}
		}
		try { //�������������
			result = number[0] / number [1];
			System.out.println(result);
		}
		catch (ArithmeticException e) { //����0�Ĵ���
			System.out.println("Second number can't be zero");
			System.exit(-1);
		}
		System.out.println(result); //����ʼ��result���ᱨ��
		//String s = Keyboard.getString();
		//System.out.println(s);
	}
}
