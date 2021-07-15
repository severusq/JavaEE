import java.util.StringTokenizer;

public class JFCTester {
	
	public static String removeNonLetters(String original) { //溢出字符串里不是字母的字符
		StringBuffer aBuffer = new StringBuffer(original.length());
		char aCharacter;
		for (int i = 0; i < original.length(); i++) {
			aCharacter = original.charAt(i); //去除字符串的每一个字符
			if (Character.isLetter(aCharacter)) { //用character的isletter函数
				aBuffer.append(new Character(aCharacter));
			}
		}
		return new String(aBuffer);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 1.2;
		Double a = new Double(x); //包裹类初始化
		Integer b = 1; //自动装箱
		int i = b.intValue(); //包裹类手动拆箱
		Integer c = Integer.valueOf("123"); //把字符串转换为包裹类
		int d = Integer.parseInt("111"); //把字符串直接转换为int
		String aString;
		aString = new String("Click this"); //字符串的声明和初始化
		aString.substring(6, 10); //提取子串
		System.out.println(aString.concat("Yes")); //拼接字符串
		String s = " Click this ";
		System.out.println(s.compareTo(aString)); //比较大小
		System.out.println(s.equals(aString)); //比较是否相等
		System.out.println(s.trim()); //去除两边的空白
		s = s.trim();
		System.out.println(s.toLowerCase()); //全部转换为小写大写字母
		System.out.println(s.toUpperCase());
		
		StringBuffer string1 = new StringBuffer(); //可以扩展的字符串类
		System.out.println(string1.capacity()); //容量默认16
		string1.ensureCapacity(40); //设置容量为40
		System.out.println(string1.capacity());
		string1.append("Tree River");
		System.out.println(string1);
		string1.setCharAt(4, '+'); //修改某一位置上的字符
		System.out.println(string1);
		
		String original = "hello 1234 world 38!";
		System.out.println(removeNonLetters(original));
		
		Integer t = 0;
		Class aClass = t.getClass(); //返回当前对象所在的类，返回类型是Class
		System.out.println(aClass.getName()); //获得类名的字符串
		
		String ss = "3.4/3-3.4*2+1+(2-0.3)";
		StringTokenizer st = new StringTokenizer(ss, "+-*/)(", true); 
		//以字符串的每一个字符为分割点，true表示分隔符也返回
		while(st.hasMoreTokens()) { //判断还有没有元素
			System.out.println(st.nextToken()); //第一次调用nextToken指向第一个元素
		}
	}

}
