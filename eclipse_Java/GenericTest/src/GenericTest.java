
class GeneralType <Type extends Number> { //���ͱ�̣��÷�ͬc++����������Type������Number���Number������
	Type object;
	public GeneralType(Type object) { //���巺�ͺ������﷨����publicǰ��<Type>
		this.object = object;
	}
	public Type getObj() {
		return object;
	}
}

class showType {
	public void showType(GeneralType<?> o) { //?��ͨ�������������һ�ַ��ͣ���Ȼ������Object��
		System.out.println(o.getObj().getClass().getName()); //��ȡType�������������
	}
}
public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showType st = new showType();
		GeneralType<Integer> i = new GeneralType<Integer> (2);
		//GeneralType<String> s = new GeneralType<String>("Hello"); //�����ƾͲ�������һ����
		st.showType(i);
		//st.showType(s);
	}

}
