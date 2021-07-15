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

public class ExceptionTester {
	public static void main(String args[]) {
		int number1 = Keyboard.getInteger();
		System.out.println(number1);
		
		int result = 0;
		int number[] = new int[2]; //数组的声明和初始化方法之一
		for (int i = 0; i < 2; i++) { //输入两个数字
			boolean valid = false;
			while (!valid) {
				try {
					number[i] = Integer.valueOf(Keyboard.getString()).intValue(); //字符串转换为数字
					valid = true;
				}
				catch (NumberFormatException e) { //输入的不是数字的错误
					System.out.println("Invalid input");
					//System.exit(-1);
				}
			}
		}
		try { //将两个数字相除
			result = number[0] / number [1];
			System.out.println(result);
		}
		catch (ArithmeticException e) { //除以0的错误
			System.out.println("Second number can't be zero");
			System.exit(-1);
		}
		System.out.println(result); //不初始化result还会报错
		//String s = Keyboard.getString();
		//System.out.println(s);
	}
}
