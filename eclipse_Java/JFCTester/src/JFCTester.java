import java.util.StringTokenizer;

public class JFCTester {
	
	public static String removeNonLetters(String original) { //����ַ����ﲻ����ĸ���ַ�
		StringBuffer aBuffer = new StringBuffer(original.length());
		char aCharacter;
		for (int i = 0; i < original.length(); i++) {
			aCharacter = original.charAt(i); //ȥ���ַ�����ÿһ���ַ�
			if (Character.isLetter(aCharacter)) { //��character��isletter����
				aBuffer.append(new Character(aCharacter));
			}
		}
		return new String(aBuffer);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 1.2;
		Double a = new Double(x); //�������ʼ��
		Integer b = 1; //�Զ�װ��
		int i = b.intValue(); //�������ֶ�����
		Integer c = Integer.valueOf("123"); //���ַ���ת��Ϊ������
		int d = Integer.parseInt("111"); //���ַ���ֱ��ת��Ϊint
		String aString;
		aString = new String("Click this"); //�ַ����������ͳ�ʼ��
		aString.substring(6, 10); //��ȡ�Ӵ�
		System.out.println(aString.concat("Yes")); //ƴ���ַ���
		String s = " Click this ";
		System.out.println(s.compareTo(aString)); //�Ƚϴ�С
		System.out.println(s.equals(aString)); //�Ƚ��Ƿ����
		System.out.println(s.trim()); //ȥ�����ߵĿհ�
		s = s.trim();
		System.out.println(s.toLowerCase()); //ȫ��ת��ΪСд��д��ĸ
		System.out.println(s.toUpperCase());
		
		StringBuffer string1 = new StringBuffer(); //������չ���ַ�����
		System.out.println(string1.capacity()); //����Ĭ��16
		string1.ensureCapacity(40); //��������Ϊ40
		System.out.println(string1.capacity());
		string1.append("Tree River");
		System.out.println(string1);
		string1.setCharAt(4, '+'); //�޸�ĳһλ���ϵ��ַ�
		System.out.println(string1);
		
		String original = "hello 1234 world 38!";
		System.out.println(removeNonLetters(original));
		
		Integer t = 0;
		Class aClass = t.getClass(); //���ص�ǰ�������ڵ��࣬����������Class
		System.out.println(aClass.getName()); //����������ַ���
		
		String ss = "3.4/3-3.4*2+1+(2-0.3)";
		StringTokenizer st = new StringTokenizer(ss, "+-*/)(", true); 
		//���ַ�����ÿһ���ַ�Ϊ�ָ�㣬true��ʾ�ָ���Ҳ����
		while(st.hasMoreTokens()) { //�жϻ���û��Ԫ��
			System.out.println(st.nextToken()); //��һ�ε���nextTokenָ���һ��Ԫ��
		}
	}

}
