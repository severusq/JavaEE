import java.io.*;

class Keyboard {
	static BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
	public static int getInteger() {
		try {
			return (Integer.valueOf(inputStream.readLine().trim()).intValue()); //trim用来去除两端空白
		}
		catch (Exception e) {
			e.printStackTrace(); //给出函数的调用序列
			return 0; //catch内也要写返回值
		}
	}
	public static String getString() {
		try {
			return (inputStream.readLine()); //读取输入,貌似啥都可以转换成字符串
		}
		catch (IOException e) {
			System.out.println(e.getMessage()); //返回描述异常的字符串
			return "0";
		}
		finally {} //不管有没有异常都要执行finally块
	}
}

class DivideByZeroException extends ArithmeticException { //自定义异常类，要继承某个异常类
	public DivideByZeroException() {
		super("Attempted to devide by zero"); //除以0非法
	}
}

public class DivideByZeroExceptionTester {
	
	private static int quotient(int numerator, int denominator) throws DivideByZeroException { //throws异常参数列表
		if (denominator == 0)
			throw new DivideByZeroException(); //throw，try-catch和c++一样
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
			System.exit(-1); //退出系统
		}
		catch (DivideByZeroException e) {
			System.out.println(e.toString());
			System.exit(-1);
		}
		System.out.println(result);
	}

}
